package com.example.TaskManagementSystem.serviceImpl;

import com.example.TaskManagementSystem.Model.User;
import com.example.TaskManagementSystem.dto.LoginRequest;
import com.example.TaskManagementSystem.dto.UserDto;
import com.example.TaskManagementSystem.repository.UserRepository;
import com.example.TaskManagementSystem.service.UserService;
import com.example.TaskManagementSystem.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User registerUser(UserDto userDto) {

        if(userRepository.findByEmailId(userDto.getEmailId()) != null){
            return null;
        }else {
            User user = new User();

            user.setName(userDto.getName());
            user.setEmailId(userDto.getEmailId());
            user.setPassword(userDto.getPassword());

            TokenUtils tokenUtils = new TokenUtils();

            String token = tokenUtils.generateToken(userDto.getEmailId());

            user.setAuthToken(token);

            return userRepository.save(user);
        }
    }

    @Override
    public User checkUser(LoginRequest loginRequest) {

        User user = userRepository.findByEmailIdAndPassword(loginRequest.getEmailId(), loginRequest.getPassword());

        if(user!= null){

            TokenUtils tokenUtils = new TokenUtils();
            String token = tokenUtils.generateToken(user.getEmailId());

            user.setAuthToken(token);
            return userRepository.save(user);
        }
        return null;
    }
}
