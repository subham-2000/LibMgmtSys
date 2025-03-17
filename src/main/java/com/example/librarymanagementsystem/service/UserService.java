package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.dto.UserCreationRequest;
import com.example.librarymanagementsystem.dto.UserCreationResponse;
import com.example.librarymanagementsystem.enums.Operator;
import com.example.librarymanagementsystem.enums.UserFilter;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.librarymanagementsystem.enums.UserType;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreationResponse addStudent(UserCreationRequest request) {
        User user = request.toUser();
        user.setUserType(UserType.STUDENT);
        User userFromDb = userRepository.save(user);
        return UserCreationResponse.builder().
                userName(userFromDb.getName()).
                userAddress(userFromDb.getAddress()).
                userEmail(userFromDb.getEmail()).
                userPhone(userFromDb.getPhoneNo()).
                build();
    }

    public List<User> filter(UserFilter filterBy, Operator operator, String value) {
        switch (filterBy){
            case NAME :
                switch (operator){
                    case EQUALS :
                        return userRepository.findByName(value);

                    case LIKE:
                        return userRepository.findByNameContains(value);
                }
        }
        return new ArrayList<>();
    }
}
