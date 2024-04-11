package com.example.projectgeneral.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projectgeneral.application.dto.IResponse;
import com.example.projectgeneral.application.dto.user.UserDataRequest;
import com.example.projectgeneral.application.dto.user.UserDto;
import com.example.projectgeneral.domain.user.User;
import com.example.projectgeneral.infrastructure.repository.user.UserRepositoryJDBC;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryJDBC userRepo;

    @Transactional(rollbackOn = Exception.class)
    @Valid
    public IResponse<UserDto> registerUser(UserDataRequest newUser) throws Exception {
        var user = new User(
                newUser.name(),
                newUser.email(),
                newUser.username(),
                newUser.password());

        userRepo.create(user);
        var createdUser = new UserDto(
                user.getName(),
                user.getEmail(),
                user.getUsername());

        return new IResponse<UserDto>(
                "Novo usuário cadastrado.",
                201,
                createdUser);
    }

    public IResponse<List<UserDto>> findAllUsers() throws Exception {
        var allUsers = userRepo.getAll();

        if (allUsers.size() == 0) {
            return new IResponse<List<UserDto>>("", 204, null);
        }

        var usersDto = allUsers.stream().map(UserDto::new).toList();

        return new IResponse<List<UserDto>>(
                allUsers.size() + " usuários encontrados",
                200,
                usersDto);
    }

    @Transactional(rollbackOn = Exception.class)
    public IResponse<String> removeUser(String username) throws Exception {
        userRepo.delete(username);

        return new IResponse<String>(
                "Usuário " + username + " removido",
                204,
                username);
    }
}
