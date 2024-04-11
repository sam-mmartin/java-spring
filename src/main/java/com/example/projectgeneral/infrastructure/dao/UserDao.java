package com.example.projectgeneral.infrastructure.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.projectgeneral.domain.user.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class UserDao {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createUser(User user) throws Exception {
        LocalDateTime datetime = LocalDateTime.now();

        user.setActive(true);
        user.setCreatedDate(datetime);

        em.persist(user);
    }

    @Transactional
    public User getUserByUsername(String username) throws Exception {
        var query = em.createNamedQuery("getByUsername", User.class)
                .setParameter("username", username);
        return query.getSingleResult();
    }

    public List<User> getAllUsers() throws Exception {
        var query = em.createNamedQuery("getAll", User.class);
        return query.getResultList();
    }

    public void deleteUser(User user) throws Exception {
        em.remove(user);
    }
}
