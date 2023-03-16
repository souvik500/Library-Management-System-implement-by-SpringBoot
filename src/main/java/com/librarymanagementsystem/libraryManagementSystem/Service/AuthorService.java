package com.librarymanagementsystem.libraryManagementSystem.Service;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Author;
import com.librarymanagementsystem.libraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService
{

    @Autowired
    AuthorRepository authorRepository;


    public void addAuthor(Author author)
    {
        authorRepository.save(author);
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
