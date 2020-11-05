package com.contacts.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contacts", uniqueConstraints =
        @UniqueConstraint(columnNames = {"email"}))
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String fullName;
    @Lob
    private Byte[] image;
}
