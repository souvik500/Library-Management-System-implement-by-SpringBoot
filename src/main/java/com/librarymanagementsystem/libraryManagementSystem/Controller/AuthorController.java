package com.librarymanagementsystem.libraryManagementSystem.Controller;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Author;
import com.librarymanagementsystem.libraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController
{
    @Autowired
    AuthorService authorService;


    @PostMapping("/addAuthor")
    public String addAuthor (@RequestBody Author author)
    {
       authorService.addAuthor(author);

       return "Author added with Author Id: " + author.getId();
    }

    @GetMapping("/allAuthor")
    public List<Author> getAllAuthor ()
    {
        return authorService.getAllAuthor();
    }
}
