package com.viiku.urlshortener.url.service.impl;

import com.viiku.urlshortener.common.exception.url.ShortCodeAlreadyExistsException;
import com.viiku.urlshortener.common.exception.url.ShortCodeGenerationException;
import com.viiku.urlshortener.common.exception.url.UrlExpiredException;
import com.viiku.urlshortener.url.mapper.UrlMapper;
import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.model.payload.request.UrlRequest;
import com.viiku.urlshortener.url.model.entity.UrlEntity;
import com.viiku.urlshortener.url.model.payload.response.UrlResponse;
import com.viiku.urlshortener.url.repository.UrlRepository;
import com.viiku.urlshortener.url.service.UrlService;
import com.viiku.urlshortener.util.Base62Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.viiku.urlshortener.config.RedisConfig.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Service class named {@link UrlServiceImpl}
 * provides implementation of all methods
 */

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;
    private final RedisTemplate<String, String> redisTemplate;

    private static final String REDIS_KEY_PREFIX = "shorturl:";
    private static final long CACHE_TTL_HOURS = 24;

    /**
     * Creates a short URL from the given request model.
     *
     * @param urlRequest contains the original long URL.
     * @return the generated short URL.
     */
    @Override
    public UrlResponse createShortUrl(UrlRequest urlRequest) {

        String shortCode = Optional.ofNullable(urlRequest.getCustomAlias())
                .filter(alias -> !alias.isEmpty())
                .orElseGet(() -> Base62Encoder.generateShortCode());

        if (urlRepository.existsByShortCode(shortCode)) {
            if (urlRequest.getCustomAlias() == null) {
                shortCode = Base62Encoder.generateShortCode();
                if (urlRepository.existsByShortCode(shortCode)) {
                    throw new ShortCodeGenerationException();
                }
            } else {
                throw new ShortCodeAlreadyExistsException(shortCode);
            }
        }

        LocalDateTime expiryDate = Optional.ofNullable(urlRequest.getExpiryDate())
                .orElse(LocalDateTime.now().plusDays(30));

        String shortUrl = buildCompleteShortUrl(shortCode);

        UrlEntity urlEntity = UrlEntity.builder()
                .originalUrl(urlRequest.getOriginalUrl())
                .shortUrl(shortUrl)
                .customAlias(urlRequest.getCustomAlias())
                .shortCode(shortCode)
                .expiryDate(expiryDate)
                .build();

        UrlEntity savedEntity = urlRepository.save(urlEntity);
        cacheUrlInRedis(savedEntity);

        Url url = urlMapper.mapToTarget(savedEntity);
        return urlMapper.mapToResponse(url);
    }


    /**
     * Retrieves a URL by short code.
     *
     * @param shortCode the short URL identifier.
     * @return the original URL if found.
     */
    @Override
    public UrlResponse getOriginalUrl(String shortCode) {

        String cachedUrl = redisTemplate.opsForValue().get(REDIS_KEY_PREFIX + shortCode);
        if (cachedUrl != null) {
            return cachedUrl;
        }

        UrlEntity urlEntity = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found: " + shortCode));

        if (urlEntity.getExpiryDate() != null &&
                urlEntity.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new UrlExpiredException(urlEntity.getShortUrl());
        }

        Url url = urlMapper.mapToTarget(urlEntity);
//        return url.getOriginalUrl();
        return urlMapper.mapToResponse(url);
    }

    private String buildCompleteShortUrl(String shortCode) {
        String domain = "https://short.url/";
        return domain + shortCode;
    }

    private void cacheUrlInRedis(UrlEntity urlEntity) {
        String key = REDIS_KEY_PREFIX + urlEntity.getShortCode();
        redisTemplate.opsForValue().set(
                key,
                urlEntity.getOriginalUrl(),
                CACHE_TTL_HOURS,
                TimeUnit.HOURS
        );
    }
}
