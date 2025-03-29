package com.viiku.urlshortener.user.repository;

import com.viiku.urlshortener.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserId(String userId);
}
