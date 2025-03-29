package com.viiku.urlshortener.user.service;

import com.viiku.urlshortener.user.User;
import com.viiku.urlshortener.user.model.payload.request.CreateUserRequest;
import com.viiku.urlshortener.user.model.payload.request.UpdateUserRequest;
import com.viiku.urlshortener.user.model.payload.response.UserResponse;

/**
 * Interface named {@link UserService} implements several methods
 * related to user creation, update and deletion
 */

public interface UserService {

    UserResponse createNewUser(CreateUserRequest createUserRequest);

    UserResponse getUser(String userId);

    UserResponse updateUser(String id, UpdateUserRequest updateUserRequest);

    void deleteUser(String id);
}
