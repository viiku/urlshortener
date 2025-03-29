package com.viiku.urlshortener.url.model.entity;

import com.viiku.urlshortener.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Entity class {@link UrlEntity} extends {@link BaseEntity}
 */

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "URLS")
public class UrlEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

//    private String userId;
    private String originalUrl;
    private String shortUrl;
    private String customAlias;
    private Date expiryDate;
}
