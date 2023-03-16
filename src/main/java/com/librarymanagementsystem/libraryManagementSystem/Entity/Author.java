package com.librarymanagementsystem.libraryManagementSystem.Entity;

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
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int mobile;

    private String email;

    /**
     * When any Author will come and register himself on this time Author did not write any book
     * so, we make make an empty list first, then we create add API to inset book for particular
     * Author..
     */
    //parent to child join
    @OneToMany (mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> bookList = new ArrayList<>();
}
