package com.librarymanagementsystem.libraryManagementSystem.Service;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Author;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Book;
import com.librarymanagementsystem.libraryManagementSystem.Repository.AuthorRepository;
import com.librarymanagementsystem.libraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public int addBook(Book book) throws Exception
    {
        Author author;
        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage()+ " Author is not Exists");
        }

        List<Book> bookList = author.getBookList();

        bookList.add(book);

        bookRepository.save(book);

        return author.getId();
    }
}
