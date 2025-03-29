package com.viiku.urlshortener.user.model.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestModel {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
}
