package com.contacts.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
//@ValidPassword
public class UserRequestDto {
    //@ValidEmail
    private String email;
    private String password;
    @NotNull(message = "The repeat password can't be null.")
    private String repeatPassword;
}
