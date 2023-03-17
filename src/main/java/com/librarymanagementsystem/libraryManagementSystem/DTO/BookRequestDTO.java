package com.librarymanagementsystem.libraryManagementSystem.DTO;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Author;
import com.librarymanagementsystem.libraryManagementSystem.Enum.Genres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookRequestDTO
{
    private String name;

    private int price;

    private Genres genres;

    private int authorId;
}
