package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn, Integer> {
}