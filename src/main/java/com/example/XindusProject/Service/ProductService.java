package com.example.XindusProject.Service;

import com.example.XindusProject.DTO.Request.AddProductRequest;
import com.example.XindusProject.Modal.Product;
import com.example.XindusProject.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(AddProductRequest productRequest) {

        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
    }
}
