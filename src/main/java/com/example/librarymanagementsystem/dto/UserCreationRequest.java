package com.example.librarymanagementsystem.dto;

import com.example.librarymanagementsystem.enums.UserStatus;
import com.example.librarymanagementsystem.model.User;
import jakarta.validation.constraints.NotBlank;
import com.example.librarymanagementsystem.enums.UserType;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserCreationRequest {

    private String userName;

    @NotBlank(message = "user email must not be blank")
    private String userEmail;

    private String userAddress;

    private String userPhone;

    public User toUser() {

        return User.
                builder().
                name(this.userName).
                email(this.userEmail).
                phoneNo(this.userPhone).
                address(this.userAddress).
                userStatus(UserStatus.ACTIVE).
//                userType(UserType.STUDENT).
                build();
    }

}
