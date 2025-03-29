package com.viiku.urlshortener.url.service;

import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.model.dto.UrlRequestModel;

/**
 * Interface {@link UrlService} for handling all business logic
 */

public interface UrlService {

    Url createShortUrl(UrlRequestModel urlRequestModel);

    Url getShortUrl(String shortUrlCode);
}
