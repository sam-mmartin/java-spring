package com.example.projectgeneral.application.services;

import org.springframework.stereotype.Service;

import com.example.projectgeneral.application.dto.user.UserDataRequest;
import com.example.projectgeneral.application.dto.user.UserDataResponse;
import com.example.projectgeneral.application.dto.user.UserDto;
import com.example.projectgeneral.domain.user.User;
import com.example.projectgeneral.infrastructure.user.UserRepositoryJDBC;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryJDBC userRepo;

    @Transactional(rollbackOn = Exception.class)
    @Valid
    public UserDataResponse registerUser(UserDataRequest newUser) throws Exception {
        var user = new User(
                newUser.name(),
                newUser.username(),
                newUser.password());

        user = userRepo.create(user);
        var createdUser = new UserDto(
                user.getName(),
                user.getUsername());

        return new UserDataResponse(
                "Novo usuário cadastrado.",
                201,
                createdUser);
    }
}
