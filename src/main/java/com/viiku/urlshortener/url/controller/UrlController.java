package com.viiku.urlshortener.url.controller;

import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.model.payload.request.UrlRequest;
import com.viiku.urlshortener.url.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Url> createShortUrl(@Valid @RequestBody UrlRequest urlRequestModel) {
        Url url = urlService.createShortUrl(urlRequestModel);
        return ResponseEntity.ok(url);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Url> getShortUrl(@PathVariable String id) {
        Url url = urlService.getShortUrl(id);
        return ResponseEntity.ok(url);
    }

}
