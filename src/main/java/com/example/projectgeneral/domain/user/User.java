package com.example.projectgeneral.domain.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "User")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "username")
@NamedNativeQueries({
        @NamedNativeQuery(name = "getAll", query = "SELECT * FROM User", resultClass = User.class),
        @NamedNativeQuery(name = "getByUsername", query = "SELECT * FROM User WHERE username = :username", resultClass = User.class)
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
