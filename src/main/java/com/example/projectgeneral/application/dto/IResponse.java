package com.example.projectgeneral.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IResponse<T> {
    private String message;
    private int statusCode;
    private T data;
}
