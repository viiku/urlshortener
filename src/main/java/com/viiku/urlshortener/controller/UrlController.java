package com.viiku.urlshortener.controller;

import com.viiku.urlshortener.model.Url;
import com.viiku.urlshortener.service.UrlService;
import com.viiku.urlshortener.model.UrlRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String createShortURL(@RequestBody UrlRequestModel urlRequestModel) {

        String shortURL = urlService.generateShortURL(urlRequestModel);
        return shortURL;
    }

    @GetMapping("/url")
    public String getShortenURL() {
        return "Shorted URL";
    }
}
