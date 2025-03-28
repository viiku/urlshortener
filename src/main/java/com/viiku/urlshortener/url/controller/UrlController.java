package com.viiku.urlshortener.url.controller;

import com.viiku.urlshortener.common.model.dto.response.CustomResponse;
import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.payload.request.UrlRequest;
import com.viiku.urlshortener.url.payload.response.UrlResponse;
import com.viiku.urlshortener.url.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @GetMapping
    public CustomResponse<String> getShortUrl(@Valid UrlRequest urlRequest) {
        Url url = urlService.createShortUrl(urlRequest);
        return CustomResponse.created(url);
    }

}
