package com.example.librarymanagementsystem.dto;


import com.example.librarymanagementsystem.enums.BookType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookFilterResponse {

    private String bookNo;
    private String bookName;
    private BookType bookType;
    private String authorName;
    private String authorEmail;
}
