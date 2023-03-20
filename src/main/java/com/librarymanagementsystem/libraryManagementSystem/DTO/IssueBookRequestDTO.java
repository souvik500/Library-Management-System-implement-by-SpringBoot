package com.librarymanagementsystem.libraryManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueBookRequestDTO
{
    private int bookId;

    private int cardId;
}
