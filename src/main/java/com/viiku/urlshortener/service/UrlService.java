package com.viiku.urlshortener.service;

import com.viiku.urlshortener.model.Url;
import com.viiku.urlshortener.model.UrlRequestModel;
import com.viiku.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String generateShortURL(UrlRequestModel urlRequestModel) {

        String shortUrl = "http://short.url/" + (urlRequestModel.getCustomAlias() != null ? urlRequestModel.getCustomAlias() : "defaultAlias");
        Date todayDateAndTime = new Date();

        Url url = new Url(
                urlRequestModel.getUserId(),
                urlRequestModel.getOriginalUrl(),
                shortUrl,
                urlRequestModel.getCustomAlias(),
                todayDateAndTime,
                urlRequestModel.getExpiryDate()
        );

        urlRepository.save(url);
        return shortUrl;
    }
}
