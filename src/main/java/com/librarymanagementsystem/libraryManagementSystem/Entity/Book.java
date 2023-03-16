package com.librarymanagementsystem.libraryManagementSystem.Entity;

import com.librarymanagementsystem.libraryManagementSystem.Enum.Genres;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    //child to parent connection
    @ManyToOne
    @JoinColumn
    Author author;
}
