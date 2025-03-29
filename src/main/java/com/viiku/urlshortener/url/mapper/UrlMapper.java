package com.viiku.urlshortener.url.mapper;

import com.viiku.urlshortener.common.model.mapper.BaseMapper;
import com.viiku.urlshortener.url.model.Url;
import com.viiku.urlshortener.url.model.entity.UrlEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting UrlEntity to Url.
 */
@Component
public class UrlMapper implements BaseMapper<UrlEntity, Url> {

    @Override
    public Url mapToTarget(UrlEntity source) {
        if (source == null) {
            return null;
        }
        return Url.builder()
                .id(source.getId())
                .originalUrl(source.getOriginalUrl())
                .shortUrl(source.getShortUrl())
                .customAlias(source.getCustomAlias())
                .expiryDate(source.getExpiryDate())
                .createdAt(source.getCreatedAt())
                .updatedAt(source.getUpdatedAt())
                .build();
    }

    @Override
    public UrlEntity mapToEntity(Url target) {
        if (target == null) {
            return null;
        }
        return UrlEntity.builder()
                .id(target.getId())
                .originalUrl(target.getOriginalUrl())
                .shortUrl(target.getShortUrl())
                .customAlias(target.getCustomAlias())
                .expiryDate(target.getExpiryDate())
                .build();
    }
}
