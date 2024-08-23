package com.example.TaskManagementSystem.controller;

import com.example.TaskManagementSystem.Model.User;
import com.example.TaskManagementSystem.dto.LoginRequest;
import com.example.TaskManagementSystem.dto.UserDto;
import com.example.TaskManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/sign-up")
    public ResponseEntity signup(@RequestBody UserDto userDto){

        User user = userService.registerUser(userDto);

        Map<String, Object> result = new HashMap<>();

        if(user!= null){
            result.put("output", user);
        }else{
            result.put("output", "email id already exist");
        }

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){

        User user = userService.checkUser(loginRequest);

        Map<String, Object> result = new HashMap<>();

        if(user!= null){
            result.put("output", user);
        }else{
            result.put("output", "invalid user name and password");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
