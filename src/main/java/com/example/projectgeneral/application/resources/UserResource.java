package com.example.projectgeneral.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectgeneral.application.dto.IResponse;
import com.example.projectgeneral.application.dto.user.UserDataRequest;
import com.example.projectgeneral.application.dto.user.UserDto;
import com.example.projectgeneral.application.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping
    public IResponse<UserDto> createUser(@RequestBody @Valid UserDataRequest newUser) throws Exception {
        System.out.println(newUser);

        return service.registerUser(newUser);
    }

    @GetMapping
    public ResponseEntity<IResponse<List<UserDto>>> findAllUsers() throws Exception {
        var response = service.findAllUsers();

        switch (response.getStatusCode()) {
            case 204:
                return ResponseEntity.noContent().build();

            default:
                return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Usuário removido")
    public void removeUser(@RequestParam String username) throws Exception {
        service.removeUser(username);
    }
}