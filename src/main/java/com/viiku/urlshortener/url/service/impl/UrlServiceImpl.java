package com.viiku.urlshortener.url.service.impl;

import com.viiku.urlshortener.common.exception.url.UrlExpiredException;
import com.viiku.urlshortener.url.mapper.UrlMapper;
import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.model.payload.request.UrlRequest;
import com.viiku.urlshortener.url.model.entity.UrlEntity;
import com.viiku.urlshortener.url.model.payload.response.UrlResponse;
import com.viiku.urlshortener.url.repository.UrlRepository;
import com.viiku.urlshortener.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.viiku.urlshortener.util.UrlShortenerGenerator.generateShortUrl;

/**
 * Service class named {@link UrlServiceImpl}
 * provides implementation of all methods
 */

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;

    /**
     * Creates a short URL from the given request model.
     *
     * @param urlRequest contains the original long URL.
     * @return the generated short URL.
     */
    @Override
    public UrlResponse createShortUrl(UrlRequest urlRequest) {

        if (urlRequest.getCustomAlias() == null) {
            /**
             * If @param customAlias is not present then use default alias
             */
            urlRequest.setCustomAlias("default");
        }

        LocalDateTime expiryDate = Optional.ofNullable(urlRequest.getExpiryDate())
                .orElse(LocalDateTime.now().plusDays(30));

        String shortUrl = generateShortUrl(urlRequest.getOriginalUrl(), urlRequest.getCustomAlias());

        UrlEntity urlEntity = UrlEntity.builder()
                .originalUrl(urlRequest.getOriginalUrl())
                .shortUrl(shortUrl)
                .customAlias(urlRequest.getCustomAlias())
                .shortCode(urlRequest.getCustomAlias())
                .expiryDate(expiryDate)
                .build();

        UrlEntity savedEntity = urlRepository.save(urlEntity);
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
    public UrlResponse getShortUrl(String shortCode) {
        UrlEntity urlEntity = urlRepository.findByShortUrl(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found: " + shortCode));

        if (urlEntity.getExpiryDate() != null &&
                urlEntity.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new UrlExpiredException(urlEntity.getShortUrl());
        }

        Url url = urlMapper.mapToTarget(urlEntity);
        return urlMapper.mapToResponse(url);
    }
}
