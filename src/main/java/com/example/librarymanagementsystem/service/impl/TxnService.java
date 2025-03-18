package com.example.librarymanagementsystem.service.impl;


import com.example.librarymanagementsystem.dto.TxnRequest;
import com.example.librarymanagementsystem.enums.TxnStatus;
import com.example.librarymanagementsystem.exception.BookException;
import com.example.librarymanagementsystem.exception.UserException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Txn;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.repository.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class TxnService {
    @Autowired
    private TxnRepository txnRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Transactional(rollbackFor = {BookException.class, UserException.class})
    public String create(TxnRequest txnRequest) throws UserException, BookException {
        // user is trying to get the book , user is valid or not?
        User userFromDb = userService.checkIfUserIsValid(txnRequest.getUserEmail());
        if(userFromDb == null){
            throw new UserException("User is not valid.");
        }

        // book no he is asking, actually belongs to my library
        Book bookFromDb = bookService.checkIfBookIsValid(txnRequest.getBookNo());
        if(bookFromDb == null){
            throw new BookException("book is not valid.");
        }
        // book a user is asking should not be assigned to some another user?
        if(bookFromDb.getUser() !=null){
            throw new BookException("book is not free to be issued.");
        }
        return createTxn(userFromDb, bookFromDb);

    }
    //t1
    @Transactional(propagation = Propagation.SUPPORTS)
    public String createTxn(User userFromDb, Book bookFromDb) throws BookException {
        // create a txn
        String txnId = UUID.randomUUID().toString();
        Txn txn = Txn.
                builder().
                txnId(txnId).
                user(userFromDb).
                book(bookFromDb).
                txnStatus(TxnStatus.ISSUED).
                issuedDate(new Date()).
                build();
        txnRepository.save(txn);
        if(txn.getSettlementAmount()==null ){
            throw new BookException("exception has been thrown");
        }
        bookService.markBookUnavailable(bookFromDb, userFromDb);
        return txnId;
    }
}