package com.example.springpracticum.first_case.controller;

import com.example.springpracticum.first_case.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/{user_id}/search")
    public List<String> getCommentsBetweenDatesForSelectedUser(
            @RequestParam(value="startDate",required = false) String startDate,
            @RequestParam(value="endDate",required = false) String endDate,
            @PathVariable int user_id){
        List<String> searchResult=new ArrayList<>();
        userService.findUserById(user_id); //check if user exist or not

        userService.productSearchBetweenDates(
                        parseStringToDates(startDate),
                        parseStringToDates(endDate),
                        user_id)
                .forEach(i->searchResult.add(i.getComment()));

        return searchResult;
    }
    private Date parseStringToDates(String string_date){
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            date = formatter.parse(string_date);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
