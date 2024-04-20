package com.example.springsecuritybasic.model.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserResponse(
        String name,
        String gender,
        Set<String> roles
) {
}
