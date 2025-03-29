package com.viiku.urlshortener.user.service.impl;

import com.viiku.urlshortener.user.User;
import com.viiku.urlshortener.user.mapper.UserMapper;
import com.viiku.urlshortener.user.model.entity.UserEntity;
import com.viiku.urlshortener.user.model.payload.request.CreateUserRequest;
import com.viiku.urlshortener.user.model.payload.request.UpdateUserRequest;
import com.viiku.urlshortener.user.model.payload.response.UserResponse;
import com.viiku.urlshortener.user.repository.UserRepository;
import com.viiku.urlshortener.user.service.UserService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createNewUser(CreateUserRequest createUserRequest) {

        String userId = getUserIdFromEmail(createUserRequest.getEmail());

        UserEntity userEntity = UserEntity.builder()
                .userId(userId)
                .firstName(createUserRequest.getFirstName())
                .middleName(createUserRequest.getMiddleName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .build();

        userRepository.save(userEntity);

        User user = userMapper.mapToTarget(userEntity);

        return userMapper.mapToResponse(user);
    }

    @Override
    public UserResponse getUser(String userId) {

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        User user = userMapper.mapToTarget(userEntity);
        return userMapper.mapToResponse(user);
    }

    @Override
    public UserResponse updateUser(String id, UpdateUserRequest updateUserRequest) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (updateUserRequest.getFirstName() != null) {
            userEntity.setFirstName(updateUserRequest.getFirstName());
        }

        if (updateUserRequest.getMiddleName() != null) {
            userEntity.setMiddleName(updateUserRequest.getMiddleName());
        }

        if (updateUserRequest.getLastName() != null) {
            userEntity.setLastName(updateUserRequest.getLastName());
        }

        userRepository.save(userEntity);

        User user = userMapper.mapToTarget(userEntity);
        return userMapper.mapToResponse(user);
    }

    @Override
    public void deleteUser(String id) {

        UserEntity userEntity = userRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("User is not present"));

        userRepository.deleteById(id);
    }

    /**
     * Generates a user ID from an email address by:
     * 1. Taking the part before the @ symbol
     * 2. Removing any non-alphanumeric characters
     * 3. Converting to lowercase
     *
     * @param email The user's email address
     * @return Generated user ID
     * @throws IllegalArgumentException if email is null or invalid
     */

    private String getUserIdFromEmail(String email) {
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid email format");
        }

        String localPart = parts[0];
        return localPart.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}
