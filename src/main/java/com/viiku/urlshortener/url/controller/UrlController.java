package com.viiku.urlshortener.url.controller;

import com.viiku.urlshortener.url.model.payload.request.UrlRequest;
import com.viiku.urlshortener.url.model.payload.response.UrlResponse;
import com.viiku.urlshortener.url.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

/**
 * Rest Controller class {@link UrlController},
 * implements all the url related endpoints
 */

@RestController
@RequestMapping("/api/v1/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UrlResponse> createShortUrl(@Valid @RequestBody UrlRequest urlRequestModel) {
        UrlResponse urlResponse = urlService.createShortUrl(urlRequestModel);
        return ResponseEntity.ok(urlResponse);
    }

    @GetMapping("/{shortCode}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode) {
//        UrlResponse urlResponse = urlService.getOriginalUrl(shortCode);
//        return ResponseEntity.ok(urlResponse);

        String originalUrl = urlService.getOriginalUrl(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}
