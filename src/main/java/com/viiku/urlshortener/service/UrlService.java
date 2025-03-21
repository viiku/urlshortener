package com.viiku.urlshortener.service;

import com.viiku.urlshortener.model.Url;
import com.viiku.urlshortener.model.UrlRequestModel;
import com.viiku.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This file will contain url shortening logic
@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String generateShortURL(UrlRequestModel urlRequestModel) {
        System.out.println(urlRequestModel);

        Url url = new Url(
                urlRequestModel.getUserId(),
                urlRequestModel.getOriginalUrl(),
                urlRequestModel.getCustomAlias(),
                urlRequestModel.getExpiryDate()
        );

        urlRepository.save(url);
        return "test";
    }
}
