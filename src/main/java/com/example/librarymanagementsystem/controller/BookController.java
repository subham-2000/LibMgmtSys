package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.dto.BookCreationResponse;
import com.example.librarymanagementsystem.enums.BookFilter;
import com.example.librarymanagementsystem.enums.Operator;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.impl.BookService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.librarymanagementsystem.dto.BookCreationRequest;

import java.util.List;

@RestController
@RequestMapping("/book")
@Validated
public class  BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public BookCreationResponse addStudent(@RequestBody BookCreationRequest request){
        return bookService.addBook(request);
    }


    @GetMapping("/filter")
    public List<Book> filteredUser(@NotNull(message = "filterby must not be null") @RequestParam("filterBy") BookFilter filterBy,
                                   @NotNull(message = "operator must not be null")  @RequestParam("operator") Operator operator,
                                   @NotBlank(message = "value must not be blank")  @RequestParam("value") String value
    ) {
        return bookService.filter(filterBy, operator, value);
    }
}
