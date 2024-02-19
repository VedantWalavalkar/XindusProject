package com.example.XindusProject.Service;

import com.example.XindusProject.DTO.Request.AddUserRequest;
import com.example.XindusProject.Modal.User;
import com.example.XindusProject.Repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;


//    @BeforeEach
//    void setUp() {
//        userService = new UserService();
//    }

    @Test
    public void shouldAddStudent(){
        System.out.println("Running AddStudent Test");
        AddUserRequest addUserRequest = AddUserRequest.builder()
                .name("Test")
                .emailId("email@mail.com")
                .password("testPassword")
                .mobileNumber("1234567890")
                .roles("ROLE_USER")
                .build();

        when(userRepository.save(any(User.class))).thenReturn(new User());
//
//        User savedUser = userService.addUser(addUserRequest);
//
//        Assertions.assertEquals(addUserRequest.getName(), savedUser.getName());
//        Assertions.assertEquals(addUserRequest.getEmailId(), savedUser.getEmail());
//        Assertions.assertEquals(addUserRequest.getPassword(), savedUser.getPassword());
//        Assertions.assertEquals(addUserRequest.getMobileNumber(), savedUser.getMobile());
//        Assertions.assertEquals(addUserRequest.getRoles(), savedUser.getRoles());
//        Assertions.assertNotNull(savedUser.getWishlist());
    }

    @Test
    void addUser() {

    }

    @Test
    void getProductlist() {
    }

    @Test
    void addToWishlist() {
    }

    @Test
    void removeFromWishlist() {
    }
}