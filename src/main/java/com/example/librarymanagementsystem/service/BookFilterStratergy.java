package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.enums.Operator;
import com.example.librarymanagementsystem.model.Book;

import java.util.List;

public interface BookFilterStratergy {
    List<Book> getFilteredBook(Operator operator, String value);
}
