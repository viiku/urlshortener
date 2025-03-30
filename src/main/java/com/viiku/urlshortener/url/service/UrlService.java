package com.viiku.urlshortener.url.service;

import com.viiku.urlshortener.url.model.payload.request.UrlRequest;
import com.viiku.urlshortener.url.model.payload.response.UrlResponse;

/**
 * Interface {@link UrlService} for handling all business logic
 */

public interface UrlService {

    UrlResponse createShortUrl(UrlRequest urlRequestModel);

    UrlResponse getShortUrl(String shortUrlCode);
}
