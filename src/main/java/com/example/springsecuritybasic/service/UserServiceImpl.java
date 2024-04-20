package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.mapper.UserMapper;
import com.example.springsecuritybasic.model.Role;
import com.example.springsecuritybasic.model.User;
import com.example.springsecuritybasic.model.dto.UserRequest;
import com.example.springsecuritybasic.model.dto.UserResponse;
import com.example.springsecuritybasic.repository.RoleRepository;
import com.example.springsecuritybasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // check of email address
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists.");
        }

        Set<Role> roles = new HashSet<>();
        //check of roles
        userRequest.roles().forEach(
                r -> {
                    var roleObject = roleRepository
                            .findByName(r)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Roles " + r + "not found!!!"));
                    roles.add(roleObject);
                }
        );

        User newUser = userMapper.toUser(userRequest, roles);
        newUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
                userRepository.save(newUser);
        return userMapper.toUserResponse(newUser);
    }
}
