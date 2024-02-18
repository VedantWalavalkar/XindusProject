package com.example.XindusProject.Transformers;

import com.example.XindusProject.DTO.Request.AddUserRequest;
import com.example.XindusProject.Modal.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTransformerTest {

    UserTransformer userTransformer;

    @BeforeEach
    void setUp() {
        userTransformer = new UserTransformer();
    }

    @Test
    public void addUserRequestToUser() {
        AddUserRequest addUserRequest = AddUserRequest.builder()
                .name("Test")
                .emailId("email@mail.com")
                .password("testPassword")
                .mobileNumber("1234567890")
                .roles("ROLE_USER")
                .build();
    }
}