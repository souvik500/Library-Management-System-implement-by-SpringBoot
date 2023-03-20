package com.librarymanagementsystem.libraryManagementSystem.Controller;

import com.librarymanagementsystem.libraryManagementSystem.DTO.IssueBookRequestDTO;
import com.librarymanagementsystem.libraryManagementSystem.DTO.IssueBookResponseDTO;
import com.librarymanagementsystem.libraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController
{
    @Autowired
    TransactionService transactionService;


    @PostMapping("/issueBookDTO")
    public ResponseEntity<IssueBookResponseDTO> issueBook (@RequestBody IssueBookRequestDTO issueBookRequestDTO) throws Exception
    {
        IssueBookResponseDTO issueBookResponseDTO;
        try {
            issueBookResponseDTO = transactionService.issueBook(issueBookRequestDTO);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage() + HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(issueBookResponseDTO, HttpStatus.OK);
    }
}
