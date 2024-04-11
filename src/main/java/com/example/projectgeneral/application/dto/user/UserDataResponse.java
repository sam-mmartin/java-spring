package com.example.projectgeneral.application.dto.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class UserDataResponse {

    private String message;
    private int statusCode;
    private UserDto data;
}
