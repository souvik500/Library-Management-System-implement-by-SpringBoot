package com.librarymanagementsystem.libraryManagementSystem.Service;

import com.librarymanagementsystem.libraryManagementSystem.DTO.BookRequestDTO;
import com.librarymanagementsystem.libraryManagementSystem.DTO.BookResponseDTO;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Author;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Book;
import com.librarymanagementsystem.libraryManagementSystem.Entity.LibraryCard;
import com.librarymanagementsystem.libraryManagementSystem.Repository.AuthorRepository;
import com.librarymanagementsystem.libraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService
{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

//    public int addBook(Book book) throws Exception
//    {
//        Author author;
//        try {
//            author = authorRepository.findById(book.getAuthor().getId()).get();
//        }
//        catch (Exception e){
//            throw new RuntimeException(e.getMessage()+ " Author is not Exists");
//        }
//
//        List<Book> bookList = author.getBookList();
//
//        bookList.add(book);
//
//        bookRepository.save(book);
//
//        return author.getId();
//    }

    public BookResponseDTO addBookDTO (BookRequestDTO bookRequestDTO)
    {
        Author author = authorRepository.findById(bookRequestDTO.getAuthorId()).get();

        Book book = new Book();

        book.setName(bookRequestDTO.getName());
        book.setGenres(bookRequestDTO.getGenres());
        book.setPrice(bookRequestDTO.getPrice());

        book.setIssued(false);

        book.setAuthor(author);
        author.getBookList().add(book);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        LibraryCard lc = new LibraryCard();
        lc.setIssueBooks(bookList);

        authorRepository.save(author);

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setName(book.getName());
        bookResponseDTO.setPrice(book.getPrice());

        return bookResponseDTO;
    }
}
