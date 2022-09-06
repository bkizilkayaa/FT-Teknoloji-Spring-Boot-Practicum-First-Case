package com.example.springpracticum.first_case.service;

import com.example.springpracticum.first_case.model.Product;
import com.example.springpracticum.first_case.repository.ProductCommentRepository;
import com.example.springpracticum.first_case.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCommentRepository productCommentRepository;


    public ProductService(ProductRepository productRepository, ProductCommentRepository productCommentRepository) {
        this.productRepository = productRepository;
        this.productCommentRepository = productCommentRepository;
    }



    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
