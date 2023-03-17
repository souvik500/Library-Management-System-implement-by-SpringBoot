package com.librarymanagementsystem.libraryManagementSystem.Controller;

import com.librarymanagementsystem.libraryManagementSystem.DTO.BookRequestDTO;
import com.librarymanagementsystem.libraryManagementSystem.DTO.BookResponseDTO;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Book;
import com.librarymanagementsystem.libraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    BookService bookService;


//    @PostMapping("/addBook")
//    public String addBook (@RequestBody Book book) throws Exception
//    {
//        int authorId;
//        try {
//            authorId = bookService.addBook(book);
//        }catch (Exception e) {
//            throw new Exception(e.getMessage()+ " then Book not added anyway");
//        }
//        return "Book added Successfully for particular Author id: "+ authorId;
//    }

    @PostMapping("/addBookDTO")
    public BookResponseDTO addBookDTO (@RequestBody BookRequestDTO bookRequestDTO)
    {
        return bookService.addBookDTO(bookRequestDTO);

    }
}
