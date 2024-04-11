package com.example.projectgeneral.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectgeneral.application.dto.user.UserDataRequest;
import com.example.projectgeneral.application.dto.user.UserDataResponse;
import com.example.projectgeneral.application.services.UserService;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping
    public UserDataResponse createUser(@RequestBody UserDataRequest newUser) throws Exception {
        System.out.println(newUser);

        UserDataResponse response = service.registerUser(newUser);

        return response;
    }
}