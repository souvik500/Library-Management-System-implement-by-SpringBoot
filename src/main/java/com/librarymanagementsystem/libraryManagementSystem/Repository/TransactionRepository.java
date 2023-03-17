package com.librarymanagementsystem.libraryManagementSystem.Repository;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
