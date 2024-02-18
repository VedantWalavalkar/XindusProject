package com.example.XindusProject.Service;

import com.example.XindusProject.DTO.Request.AddUserRequest;
import com.example.XindusProject.Modal.User;
import com.example.XindusProject.Modal.Wishlist;
import com.example.XindusProject.Repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

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

        User user = userService.addUser(addUserRequest);

        Assertions.assertEquals(addUserRequest.getName(), user.getName());
        Assertions.assertEquals(addUserRequest.getEmailId(), user.getEmail());
        Assertions.assertEquals(addUserRequest.getPassword(), user.getPassword());
        Assertions.assertEquals(addUserRequest.getMobileNumber(), user.getMobile());
        Assertions.assertEquals(addUserRequest.getRoles(), user.getRoles());
        Assertions.assertNotNull(user.getWishlist());
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