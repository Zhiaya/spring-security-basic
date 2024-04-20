package com.example.springsecuritybasic.restcontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admins")
public class AdminRestController {
    @GetMapping
    public String getAllUsers() {
        return "All users";
    }

    @DeleteMapping
    public String deleteUser() {
        return "User deleted";
    }
}
