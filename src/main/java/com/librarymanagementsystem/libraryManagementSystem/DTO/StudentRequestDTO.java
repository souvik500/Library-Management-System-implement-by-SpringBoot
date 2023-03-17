package com.librarymanagementsystem.libraryManagementSystem.DTO;

import com.librarymanagementsystem.libraryManagementSystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StudentRequestDTO
{
    private String name;

    private int age;

    private String email;

    private Department department;
}
