package com.viiku.urlshortener.url.service.impl;

import com.viiku.urlshortener.url.mapper.UrlMapper;
import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.model.payload.request.UrlRequest;
import com.viiku.urlshortener.url.model.entity.UrlEntity;
import com.viiku.urlshortener.url.repository.UrlRepository;
import com.viiku.urlshortener.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
     * @param urlRequestModel contains the original long URL.
     * @return the generated short URL.
     */
    @Override
    public Url createShortUrl(UrlRequest urlRequestModel) {

        String shortUrlCode = generateShortUrl(urlRequestModel.getOriginalUrl(), urlRequestModel.getCustomAlias());

        UrlEntity urlEntity = UrlEntity.builder()
                .originalUrl(urlRequestModel.getOriginalUrl())
                .shortUrl(shortUrlCode)
                .customAlias(urlRequestModel.getCustomAlias())
                .expiryDate(urlRequestModel.getExpiryDate())
                .build();

        UrlEntity savedEntity = urlRepository.save(urlEntity);
        return urlMapper.mapToTarget(savedEntity);
    }


    /**
     * Retrieves a URL by short code.
     *
     * @param shortUrlCode the short URL identifier.
     * @return the original URL if found.
     */
    @Override
    public Url getShortUrl(String shortUrlCode) {
        UrlEntity urlEntity = urlRepository.findByShortUrl(shortUrlCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found: " + shortUrlCode));

        return urlMapper.mapToTarget(urlEntity);
    }

    /**
     * Generates a random short URL code.
     * @return a unique short URL identifier.
     */
/*    private String generateShortUrl() {
        return UUID.randomUUID().toString().substring(0, 8); // Example: 8-character hash
    }*/
}
