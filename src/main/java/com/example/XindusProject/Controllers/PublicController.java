package com.example.XindusProject.Controllers;

import com.example.XindusProject.DTO.Request.AddUserRequest;
import com.example.XindusProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicController {

    @Autowired
    UserService userService;


    // THIS API IS USED TO ADD USER AND IS A PUBLIC i.e. OPEN API.
    @PostMapping("/add_user")
    public ResponseEntity createUser(@RequestBody AddUserRequest addUserRequest){
        try{
            userService.addUser(addUserRequest);
            return new ResponseEntity("Hello User, your account has been created. Login to Proceed", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity("Enter valid Details", HttpStatus.BAD_REQUEST);
        }
    }
}
