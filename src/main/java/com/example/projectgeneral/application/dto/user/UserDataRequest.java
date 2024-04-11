package com.example.projectgeneral.application.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDataRequest(@NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String username,
        @NotBlank @Pattern(regexp = "\\d{6,30}") String password) {
}
