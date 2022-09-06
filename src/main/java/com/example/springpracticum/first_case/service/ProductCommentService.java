package com.example.springpracticum.first_case.service;

import com.example.springpracticum.first_case.model.ProductComment;
import com.example.springpracticum.first_case.repository.ProductCommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCommentService {
    private final ProductCommentRepository productCommentRepository;

    public ProductCommentService(ProductCommentRepository productCommentRepository) {
        this.productCommentRepository = productCommentRepository;
    }

    public List<String> getCommentsForGivenProductId(int product_id) {
        List<ProductComment> productCommentList=
                productCommentRepository.getCommentsForGivenProductId(product_id);
        List<String> commentList=new ArrayList<>();

        productCommentList.forEach(i -> commentList.add(i.getComment()));

        return commentList;
    }
}
