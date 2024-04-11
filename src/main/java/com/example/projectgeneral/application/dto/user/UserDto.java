package com.example.projectgeneral.application.dto.user;

import com.example.projectgeneral.domain.user.User;

public record UserDto(String name, String email, String username) {

    public UserDto(User user) {
        this(user.getName(), user.getEmail(), user.getUsername());
    }
}
