package com.company.turboaz.security;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;

}
