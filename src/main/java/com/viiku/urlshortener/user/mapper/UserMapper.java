package com.viiku.urlshortener.user.mapper;

import com.viiku.urlshortener.common.model.mapper.BaseMapper;
import com.viiku.urlshortener.user.User;
import com.viiku.urlshortener.user.model.entity.UserEntity;
import com.viiku.urlshortener.user.model.payload.response.UserResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper class named {@link UserMapper} for mapping between
 * {@link UserEntity} and {@link User} DTO and vice versa
 */

@Component
public class UserMapper implements BaseMapper<UserEntity, User> {

    @Override
    public User mapToTarget(UserEntity source) {
        if(source == null) {
            return null;
        }

        return User.builder()
                .userId(source.getUserId())
                .firstName(source.getFirstName())
                .middleName(source.getMiddleName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .createdAt(source.getCreatedAt())
                .updatedAt(source.getUpdatedAt())
                .build();
    }

    @Override
    public UserEntity mapToEntity(User target) {
        if (target == null) {
            return null;
        }

        return UserEntity.builder()
                .userId(target.getUserId())
                .firstName(target.getFirstName())
                .middleName(target.getMiddleName())
                .lastName(target.getLastName())
                .email(target.getEmail())
                .build();
    }

    /**
     * Converts {@link User} to {@link UserResponse} for API responses
     */
    public UserResponse mapToResponse(User user) {
        if (user == null) {
            return null;
        }

        return new UserResponse(user.getUserId(), user.getEmail());
    }
}
