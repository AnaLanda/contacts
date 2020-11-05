package com.contacts.model.dto;

import lombok.Data;

@Data
public class ContactRequestDto {
    private String email;
    private String fullName;
    private Byte[] image;
}
