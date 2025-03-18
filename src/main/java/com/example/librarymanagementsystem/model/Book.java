package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.enums.BookType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class Book extends TimeStamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(length = 20, unique = true)
    private String bookNo;

    @Enumerated
    private BookType bookType;

    @Column(nullable = false)
    private Double securityAmount;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "author_id", referencedColumnName = "id"),
            @JoinColumn(name = "author_email", referencedColumnName = "email")
    })
    @JsonIgnoreProperties(value = "bookList")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Txn> txnList;

}
// id as an single, composite key
// 1 -> a1
// 2-> a1
// many to many
