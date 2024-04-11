package com.example.projectgeneral.domain.user;

import java.util.List;

public interface UserRepository {
    void create(User user) throws Exception;

    List<User> getAll() throws Exception;

    void delete(String username) throws Exception;
}
