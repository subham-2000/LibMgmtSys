package com.example.librarymanagementsystem.service.impl;


import com.example.librarymanagementsystem.enums.Operator;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookFilterStratergy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookTypeFilterImpl implements BookFilterStratergy {
    @Override
    public List<Book> getFilteredBook(Operator operator, String value) {
        return List.of();
    }
}