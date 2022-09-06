package com.example.springpracticum.first_case.controller;

import com.example.springpracticum.first_case.model.ProductComment;
import com.example.springpracticum.first_case.service.ProductCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/comments")
public class ProductCommentController {
    private final ProductCommentService productCommentService;

    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @GetMapping
    public ResponseEntity<List<ProductComment>> getAllComments(){
        return new ResponseEntity<>(productCommentService.getAllComments(), OK);
    }






}
