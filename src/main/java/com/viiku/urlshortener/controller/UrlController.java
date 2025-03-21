package com.viiku.urlshortener.controller;

import com.viiku.urlshortener.CreateUrlShortener;
import com.viiku.urlshortener.model.Url;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shorten")
public class UrlController {

    @PostMapping
    public String createShortURL(@RequestBody Url url) {
        CreateUrlShortener createUrlShortener = new CreateUrlShortener(
                UUID.randomUUID().toString(),
                url.getUserId(),
                url.getOriginalUrl(),
                url.getCustomAlias(),
                url.getExpiryDate()
        );
        return "URL shorten service";
    }
}
