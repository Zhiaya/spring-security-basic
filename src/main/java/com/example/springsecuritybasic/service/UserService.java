package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.dto.UserRequest;
import com.example.springsecuritybasic.model.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
