package com.example.XindusProject.Transformers;

import com.example.XindusProject.DTO.Request.AddUserRequest;
import com.example.XindusProject.Modal.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

public class UserTransformer {

    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static User addUserRequestToUser(AddUserRequest addUserRequest){
        return User.builder()
                .email(addUserRequest.getEmailId())
                .mobile(addUserRequest.getMobileNumber())
                .name(addUserRequest.getName())
                .password(passwordEncoder.encode(addUserRequest.getPassword()))
                .roles(addUserRequest.getRoles())
                .build();
    }
}
