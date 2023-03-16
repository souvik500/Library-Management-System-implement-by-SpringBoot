package com.librarymanagementsystem.libraryManagementSystem.Controller;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Student;
import com.librarymanagementsystem.libraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentService studentService;


    @PostMapping("/addStudent")
    public void addStudent (@RequestBody Student student)
    {
        studentService.addStudent(student);
        System.out.println(student.getName() + " Student added Successfully");
    }
}
