package com.viiku.urlshortener.url.repository;

import com.viiku.urlshortener.url.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long>{

}
