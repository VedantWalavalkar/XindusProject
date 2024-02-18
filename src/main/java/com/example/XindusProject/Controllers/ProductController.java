package com.example.XindusProject.Controllers;

import com.example.XindusProject.DTO.Request.AddProductRequest;
import com.example.XindusProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    // ADD PRODUCT API WAS CREATED FOR ADDING SOME PRODUCTS TO TEST THE API, EVEN THOUGH IT IS NOT MENTIONED IN ASSIGNMENT.

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody AddProductRequest productRequest){
        productService.addProduct(productRequest);
        return new ResponseEntity("Product added successfully", HttpStatus.CREATED);
    }
}
