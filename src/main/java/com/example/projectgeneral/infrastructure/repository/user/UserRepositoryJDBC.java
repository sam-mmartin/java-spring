package com.example.projectgeneral.infrastructure.repository.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.projectgeneral.domain.user.User;
import com.example.projectgeneral.domain.user.UserRepository;
import com.example.projectgeneral.infrastructure.dao.UserDao;

import jakarta.transaction.Transactional;

@Repository
public class UserRepositoryJDBC implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void create(User user) throws Exception {
        userDao.createUser(user);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void delete(String username) throws Exception {
        var deletedUser = userDao.getUserByUsername(username);
        userDao.deleteUser(deletedUser);
    }
}
