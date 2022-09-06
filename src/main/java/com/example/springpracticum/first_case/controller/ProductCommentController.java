package com.example.springpracticum.first_case.controller;

import com.example.springpracticum.first_case.service.ProductCommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class ProductCommentController {
    private final ProductCommentService productCommentService;

    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @GetMapping("/products/{product_id}")
    public List<String> getCommentsForGivenProduct(@PathVariable int product_id){
        return productCommentService.getCommentsForGivenProductId(product_id);
    }
}
