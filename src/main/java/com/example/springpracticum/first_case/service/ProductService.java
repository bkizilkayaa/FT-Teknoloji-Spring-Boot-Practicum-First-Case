package com.example.springpracticum.first_case.service;

import com.example.springpracticum.first_case.exception.ProductNotFoundById;
import com.example.springpracticum.first_case.model.Product;
import com.example.springpracticum.first_case.model.ProductComment;
import com.example.springpracticum.first_case.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCommentService productCommentService;


    public ProductService(ProductRepository productRepository, ProductCommentService productCommentService) {
        this.productRepository = productRepository;
        this.productCommentService = productCommentService;
    }



    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(int product_id) {
        return productRepository.findById(product_id)
                .orElseThrow(()-> new ProductNotFoundById("product not found by id : "+product_id));
    }

    public List<String> getCommentsForGivenProductId(int product_id) {
        findProductById(product_id); //responses 404 error if product not found.
        return productCommentService.getCommentsForGivenProductId(product_id);
    }

    public List<Product> getProductsWhichIsExpired() {
        try {
            Date dt=new Date();
            return productRepository.getProductsWhichIsExpired(dt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> getProductsWhichIsNotExpired() {
        try {
            Date dt=new Date();
            return productRepository.getProductsWhichIsNotExpired(dt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductComment> productSearchBetweenDates(Date startDate, Date endDate, int product_id) {
        return productCommentService.
                productSearchBetweenDates(
                        startDate,
                        endDate,
                        product_id);
    }


}
