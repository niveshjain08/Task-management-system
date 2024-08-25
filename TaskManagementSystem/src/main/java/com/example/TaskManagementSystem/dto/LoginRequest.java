package com.example.TaskManagementSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String emailId;
    private String password;
}
