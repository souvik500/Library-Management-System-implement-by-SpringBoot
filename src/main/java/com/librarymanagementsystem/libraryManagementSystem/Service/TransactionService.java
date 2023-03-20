package com.librarymanagementsystem.libraryManagementSystem.Service;

import com.librarymanagementsystem.libraryManagementSystem.DTO.IssueBookRequestDTO;
import com.librarymanagementsystem.libraryManagementSystem.DTO.IssueBookResponseDTO;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Book;
import com.librarymanagementsystem.libraryManagementSystem.Entity.LibraryCard;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Student;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Transaction;
import com.librarymanagementsystem.libraryManagementSystem.Enum.Status;
import com.librarymanagementsystem.libraryManagementSystem.Enum.TransactionStatus;
import com.librarymanagementsystem.libraryManagementSystem.Repository.BookRepository;
import com.librarymanagementsystem.libraryManagementSystem.Repository.LibraryCardRepository;
import com.librarymanagementsystem.libraryManagementSystem.Repository.StudentRepository;
import com.librarymanagementsystem.libraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService
{
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    LibraryCardRepository libraryCardRepository;

    @Autowired
    BookRepository bookRepository;

    public IssueBookResponseDTO issueBook (IssueBookRequestDTO issueBookRequestDTO) throws  Exception
    {
        Transaction transaction = new Transaction();

        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
//        List<Book> bookList = new ArrayList<>();

        LibraryCard libraryCard;
        Book book;
        try {
            libraryCard = libraryCardRepository.findById(issueBookRequestDTO.getCardId()).get();
        }
        catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction.setMessage("Id is not Exist");
            transactionRepository.save(transaction);
            throw new RuntimeException("Id is not Exist");
        }

        try {
            book = bookRepository.findById(issueBookRequestDTO.getBookId()).get();
        }
        catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction.setMessage("Book Id is not Valid");
            transactionRepository.save(transaction);
            throw new RuntimeException("Book Id is not Valid");
        }

        //Library card and Book is Valid
        if (libraryCard.getCardStatus() != Status.ACTIVATE)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction.setMessage("Id is not Activated");
            transactionRepository.save(transaction);
            throw new RuntimeException(libraryCard.getCardId() + " Card is DeActivate");
        }

        if (book.isIssued())
        {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction.setMessage("Book already Issued");
            transactionRepository.save(transaction);
            throw new RuntimeException("This " + book.getName() + " already issued");
        }

        /**
         * Set Element to Transaction Repository too after book and Card Validating
         */

        transaction.setBook(book);
        transaction.setLibraryCard(libraryCard);

        book.setIssued(true);
        book.setLibraryCard(libraryCard);

        libraryCard.getTransactions().add(transaction);

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        /**
         * Save all transaction and Book details and also card because Library card is parent
         * of Book and Transaction
         */
        libraryCardRepository.save(libraryCard);

        //prepare responseDTO
        IssueBookResponseDTO issueBookResponseDTO = new IssueBookResponseDTO();

        issueBookResponseDTO.setBookName(book.getName());
        issueBookResponseDTO.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDTO.setTransactionId(transaction.getTransactionNumber());

        return issueBookResponseDTO;
    }
}
