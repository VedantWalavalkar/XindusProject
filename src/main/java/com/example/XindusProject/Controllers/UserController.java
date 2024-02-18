package com.example.XindusProject.Controllers;

import com.example.XindusProject.DTO.Response.ProductResponse;
import com.example.XindusProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    // HERE ALL THE API MENTIONED IN THE ASSIGNMENT ARE CREATED.


    // STARTING WITH GETWISHLIST, WHICH IS USED TO GET WISHLIST OF PARTICULAR USER BY SENDING ITS USER ID.
    @GetMapping("/getWishlist")
    public ResponseEntity getWishlist(@RequestParam("id") int id){
        List<ProductResponse> response = userService.getProductlist(id);
        return new ResponseEntity(response, HttpStatus.FOUND);
    }

    // ADD TO WISHLIST IS USED TO ADD PRODUCTS TO USER WISHLIST, AND TAKES INPUT PARAMS AS PRODID AND USERID.
    @PutMapping("/addToWishlist")
    public ResponseEntity addToWishlist(@RequestParam("prodId") int prodId, @RequestParam("userId") int userId){
        try{
            userService.addToWishlist(prodId, userId);
            return new ResponseEntity<>("Added to wishlist", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    // SIMILARLY REMOVE FROM WISHLIST, REMOVES THE PRODUCT FROM THE WISHLIST OF THE USER.
    @RequestMapping("/removeFromWishlist")
    public ResponseEntity removeFromWishlist(@RequestParam("prodId") int prodId, @RequestParam("userId") int userId){

        try{
            userService.removeFromWishlist(prodId, userId);
            return new ResponseEntity<>("Removed from wishlist", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }
}
