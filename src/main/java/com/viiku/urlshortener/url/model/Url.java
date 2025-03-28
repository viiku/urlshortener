package com.viiku.urlshortener.url.model;

import com.viiku.urlshortener.common.model.BaseDomainModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Url extends BaseDomainModel {

    private String originalUrl;
    private String shortUrl;
    private Date expiryDate;
}
