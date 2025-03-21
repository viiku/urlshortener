package com.viiku.urlshortener.repository;

import com.viiku.urlshortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long>{

}
