package com.company.turboaz.dto.request;

import com.company.turboaz.model.Role;
import lombok.Data;

@Data
public class UserRequestDTO {

    private String name;
    private String phoneNumber;
    private String email;
    private String location;
    private String password;
    private Role role;

}
