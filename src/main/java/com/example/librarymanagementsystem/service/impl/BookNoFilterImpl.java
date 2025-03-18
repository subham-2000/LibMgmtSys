package com.example.librarymanagementsystem.service.impl;


import com.example.librarymanagementsystem.dto.BookFilterResponse;
import com.example.librarymanagementsystem.enums.Operator;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.service.BookFilterStratergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookNoFilterImpl implements BookFilterStratergy {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getFilteredBook(Operator operator, String value) {
        if(!operator.equals(Operator.EQUALS)){
            throw  new IllegalArgumentException("Only Equals is expected with book no");
        }
        List<Book> books = bookRepository.findByBookNo(value);
        return books;
//        return books.
//                stream().
//                map(book -> convertToBookFilterResponse(book)).
//                collect(Collectors.toList());
    }

    private BookFilterResponse convertToBookFilterResponse(Book book) {
        return BookFilterResponse.
                builder().
                bookNo(book.getBookNo()).
                authorEmail(book.getAuthor().getEmail()).
                authorName(book.getAuthor().getName()).
                bookType(book.getBookType()).
                bookName(book.getTitle()).
                build();
    }
}