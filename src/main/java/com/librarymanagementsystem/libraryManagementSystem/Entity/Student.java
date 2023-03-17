package com.librarymanagementsystem.libraryManagementSystem.Entity;

import com.librarymanagementsystem.libraryManagementSystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    Department department;


    /**
     * One-to-one Relationship b/w parent(Student) to child(LibraryCard) class
     * cascade = CascadeType.ALL means When any admission in university on this time Library card generated Automatically
     * mappedBy = "student" means its connect with child class
     */
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCard libraryCard;

}
