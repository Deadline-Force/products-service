package com.deadlineforce.backend.entity;

import com.deadlineforce.backend.entity.converter.AuthorizationRolesConverter;
import com.deadlineforce.backend.security.details.AuthorizationRoles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username, login;
    @JsonIgnore
    private String password;
    @Column(name = "user_role")
    @Convert(converter = AuthorizationRolesConverter.class)
    private AuthorizationRoles role = AuthorizationRoles.CLIENT;
    @JsonIgnore
    @RestResource(exported = false)
    @OneToMany(mappedBy = "userOwner")
    private List<Transaction> transactions;

    public User(String username, String login, String password) {
        this.username = username;
        this.login = login;
        this.password = password;
    }
}
