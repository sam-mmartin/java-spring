package com.example.projectgeneral.infrastructure.user;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.example.projectgeneral.domain.user.User;
import com.example.projectgeneral.domain.user.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class UserRepositoryJDBC implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public User create(User user) throws Exception {
        LocalDateTime datetime = LocalDateTime.now();

        user.setActive(true);
        user.setCreatedDate(datetime);

        em.persist(user);

        return user;
    }
}
