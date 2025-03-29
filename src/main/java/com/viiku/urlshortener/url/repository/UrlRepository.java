package com.viiku.urlshortener.url.repository;

import com.viiku.urlshortener.url.model.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA Repository for database queries
 */

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, String>{

    /**
     * Finds a URL entity by its short URL code.
     *
     * @param shortUrl the unique short URL identifier.
     * @return an Optional containing the UrlEntity if found, otherwise empty.
     */
    Optional<UrlEntity> findByShortUrl(String shortUrl);
}
