package com.example.springpracticum.first_case.service;

import com.example.springpracticum.first_case.exception.UserNotFoundException;
import com.example.springpracticum.first_case.model.User;
import com.example.springpracticum.first_case.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductCommentService productCommentService;

    public UserService(UserRepository userRepository, ProductCommentService productCommentService) {
        this.userRepository = userRepository;
        this.productCommentService = productCommentService;
    }

    public User findUserById(int user_id) {
        return userRepository.findById(user_id)
                .orElseThrow(()->new UserNotFoundException("user not found by id : "+user_id));
    }

    public List<String> getUserComments(int user_id) {
         findUserById(user_id);
         return productCommentService.getUserComments(user_id);
    }
}
