package com.librarymanagementsystem.libraryManagementSystem.Entity;

import com.librarymanagementsystem.libraryManagementSystem.Enum.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class LibraryCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private String validTill;

    @Enumerated(EnumType.STRING)
    private Status cardStatus;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updateDate;


    @OneToOne
    @JoinColumn
    Student student;


    //Parent(Library Card) to child(Transaction) Relationship [One to Many]
    @OneToMany(mappedBy = "libraryCard", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();


    //Parent(Library Card) to child(Book) Relationship [One to Many]
    @OneToMany(mappedBy = "libraryCard", cascade = CascadeType.ALL)
    List<Book> issueBooks = new ArrayList<>();
}
