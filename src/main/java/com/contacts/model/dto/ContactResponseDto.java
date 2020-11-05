package com.contacts.model.dto;

import lombok.Data;

@Data
public class ContactResponseDto {
    private Long id;
    private String email;
    private String fullName;
    private Byte[] image;
}
