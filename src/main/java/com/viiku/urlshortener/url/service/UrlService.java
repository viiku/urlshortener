package com.viiku.urlshortener.url.service;

import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.model.payload.request.UrlRequest;

/**
 * Interface {@link UrlService} for handling all business logic
 */

public interface UrlService {

    Url createShortUrl(UrlRequest urlRequestModel);

    Url getShortUrl(String shortUrlCode);
}
