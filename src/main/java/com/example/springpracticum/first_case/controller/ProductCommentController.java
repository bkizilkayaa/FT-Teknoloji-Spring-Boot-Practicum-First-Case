package com.example.springpracticum.first_case.controller;

import com.example.springpracticum.first_case.service.ProductCommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class ProductCommentController {
    private final ProductCommentService productCommentService;

    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }






}
