package com.example.TaskManagementSystem.service;

import com.example.TaskManagementSystem.Model.User;
import com.example.TaskManagementSystem.dto.LoginRequest;
import com.example.TaskManagementSystem.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(UserDto userDto);

    User checkUser(LoginRequest loginRequest);
}
