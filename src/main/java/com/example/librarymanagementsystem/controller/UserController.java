package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.dto.UserCreationRequest;
import com.example.librarymanagementsystem.dto.UserCreationResponse;
import com.example.librarymanagementsystem.enums.Operator;
import com.example.librarymanagementsystem.enums.UserFilter;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addStudent")
    public UserCreationResponse addStudent(@RequestBody @Validated UserCreationRequest request){
        return userService.addStudent(request);
    }

    @GetMapping("/filter")
    public List<User> filteredUser(@RequestParam("filterBy") UserFilter filterBy,
                                   @RequestParam("operator") Operator operator,
                                   @RequestParam("value") String value
    ) {
        return userService.filter(filterBy, operator, value);
    }
}
