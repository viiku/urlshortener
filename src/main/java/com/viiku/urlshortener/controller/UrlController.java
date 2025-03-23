package com.viiku.urlshortener.controller;

import com.viiku.urlshortener.model.UrlResponseModel;
import com.viiku.urlshortener.service.UrlService;
import com.viiku.urlshortener.model.UrlRequestModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseModel> createShortURL(@Valid @RequestBody UrlRequestModel urlRequestModel) {

        String shortURL = urlService.generateShortURL(urlRequestModel);

        UrlResponseModel urlResponseModel = new UrlResponseModel();
        urlResponseModel.setOriginalUrl(urlRequestModel.getOriginalUrl());
        urlResponseModel.setShortUrl(shortURL);

        return ResponseEntity.status(HttpStatus.CREATED).body(urlResponseModel);
    }

    @GetMapping("/url")
    public String getShortenURL() {

        return "Shorted URL";
    }
}
