package com.viiku.urlshortener.url.service;

import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.payload.request.UrlRequest;

public interface UrlService {

    Url createShortUrl(UrlRequest urlRequest);

}
