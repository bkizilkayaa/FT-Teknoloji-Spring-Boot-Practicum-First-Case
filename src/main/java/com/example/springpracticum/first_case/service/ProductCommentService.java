package com.example.springpracticum.first_case.service;

import com.example.springpracticum.first_case.model.ProductComment;
import com.example.springpracticum.first_case.repository.ProductCommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

        return iterateAndReturnAsStringList(productCommentList);
    }

    public List<String> getUserComments(int user_id) {
        List<ProductComment> productCommentList=
                productCommentRepository.getUserComments(user_id);
        return iterateAndReturnAsStringList(productCommentList);
    }

    private List<String> iterateAndReturnAsStringList(List<ProductComment> productCommentList){
        List<String> commentList=new ArrayList<>();

        productCommentList.forEach(i -> commentList.add(i.getComment()));

        return commentList;
    }

    public List<ProductComment> productSearchBetweenDates(Date startDate, Date endDate, int product_id) {
        return productCommentRepository.productSearchBetweenDates(startDate,endDate,product_id);
    }

    public List<ProductComment> getAllComments() {
        return productCommentRepository.findAll();
    }

    public List<ProductComment> getCommentsForGivenUser(Date startDate, Date endDate, int user_id) {
        return productCommentRepository.getCommentsForGivenUser(startDate,endDate,user_id);
    }
}
