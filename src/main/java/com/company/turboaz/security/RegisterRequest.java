package com.company.turboaz.security;

import com.company.turboaz.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String location;
    private Role role;

}
