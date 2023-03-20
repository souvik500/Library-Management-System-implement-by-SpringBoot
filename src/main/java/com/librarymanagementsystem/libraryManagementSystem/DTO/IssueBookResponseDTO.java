package com.librarymanagementsystem.libraryManagementSystem.DTO;

import com.librarymanagementsystem.libraryManagementSystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueBookResponseDTO
{
    private String  transactionId;

    private String bookName;

    private TransactionStatus transactionStatus;
}
