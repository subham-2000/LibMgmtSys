package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.enums.TxnStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Txn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String txnId;

    private TxnStatus txnStatus;

    private Double settlementAmount; // depending upon when u are returning the book

    private Date issuedDate;

    private Date submittedDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Book book;

}
