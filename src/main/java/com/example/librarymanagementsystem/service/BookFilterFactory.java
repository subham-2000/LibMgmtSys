package com.example.librarymanagementsystem.service;



import com.example.librarymanagementsystem.enums.BookFilter;
import com.example.librarymanagementsystem.service.impl.BookNoFilterImpl;
import com.example.librarymanagementsystem.service.impl.BookTitleFilterImpl;
import com.example.librarymanagementsystem.service.impl.BookTypeFilterImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookFilterFactory {

    private final Map<BookFilter, BookFilterStratergy> stratergies = new HashMap<>();

    public BookFilterFactory(BookNoFilterImpl bookNoFilter, BookTitleFilterImpl bookTitleFilter, BookTypeFilterImpl bookTypeFilter){
        stratergies.put(BookFilter.BOOK_NO, bookNoFilter);
        stratergies.put(BookFilter.BOOK_TYPE, bookTypeFilter);
        stratergies.put(BookFilter.BOOK_TITLE, bookTitleFilter);
    }
    public BookFilterStratergy getStratergy(BookFilter filter){
        return stratergies.get(filter);
    }

}