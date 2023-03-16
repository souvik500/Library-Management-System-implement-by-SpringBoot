package com.librarymanagementsystem.libraryManagementSystem.Service;

import com.librarymanagementsystem.libraryManagementSystem.Entity.LibraryCard;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Student;
import com.librarymanagementsystem.libraryManagementSystem.Enum.Status;
import com.librarymanagementsystem.libraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student)
    {
        LibraryCard lb = new LibraryCard(); //Object Creation

        lb.setValidTill("23/04/2023"); //Set Date
        lb.setCardStatus(Status.ACTIVATE);  // Set Card Status
        lb.setStudent(student); // Set current Student everytime..

        student.setLibraryCard(lb);

        studentRepository.save(student); //Then save to `lms` Database
    }
}
