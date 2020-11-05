package com.contacts.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "users", uniqueConstraints =
        @UniqueConstraint(columnNames = {"email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles;
}
