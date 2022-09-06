package com.example.springpracticum.first_case.controller;


import com.example.springpracticum.first_case.model.Product;
import com.example.springpracticum.first_case.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts() , OK);

    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product newProduct){
        return new ResponseEntity<>(productService.addProduct(newProduct),CREATED);
    }
}
