package com.example.springpracticum.first_case.controller;

import com.example.springpracticum.first_case.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{user_id}/comments")
    public List<String> getUserComments(@PathVariable int user_id){
        return userService.getUserComments(user_id);
    }
}
