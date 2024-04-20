package com.example.springsecuritybasic.restcontroller;

import com.example.springsecuritybasic.model.User;
import com.example.springsecuritybasic.model.dto.UserRequest;
import com.example.springsecuritybasic.model.dto.UserResponse;
import com.example.springsecuritybasic.service.UserService;
import com.example.springsecuritybasic.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {
    private final UserService userService;

    @PostMapping("/register")
    public BaseResponse<UserResponse> createNewUser(@RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));
    }
}
