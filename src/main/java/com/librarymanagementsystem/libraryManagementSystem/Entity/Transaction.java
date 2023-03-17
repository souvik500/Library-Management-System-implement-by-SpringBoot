package com.librarymanagementsystem.libraryManagementSystem.Entity;

import com.librarymanagementsystem.libraryManagementSystem.Enum.TransactionStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int transactionNumber;

    private boolean isIssueOperation;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;

    //Relationship b/w child to parent(Book) of [many-one]
    @ManyToOne
    @JoinColumn
    Book book;

    //Relationship b/w child(Transactions) to parent(Library Card) of [many-one]
    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;
}
