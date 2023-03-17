package com.librarymanagementsystem.libraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanagementsystem.libraryManagementSystem.Enum.Genres;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String name;

    private int price;

    @Enumerated(EnumType.STRING)
    private Genres genres;

    private boolean isIssued;

    //child to parent connection
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;

    //connection b/w Book to Transaction [1 to many]
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transaction = new ArrayList<>();

    //Connection b/w child(Book) to parent(LibraryCard) of many-one
    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;

}
