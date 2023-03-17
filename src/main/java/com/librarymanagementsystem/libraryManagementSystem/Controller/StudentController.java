package com.librarymanagementsystem.libraryManagementSystem.Controller;

import com.librarymanagementsystem.libraryManagementSystem.DTO.StudentRequestDTO;
import com.librarymanagementsystem.libraryManagementSystem.DTO.StudentResponseDTO;
import com.librarymanagementsystem.libraryManagementSystem.DTO.StudentUpdateEmail_RequestDTO;
import com.librarymanagementsystem.libraryManagementSystem.Entity.Student;
import com.librarymanagementsystem.libraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentService studentService;


    @PostMapping("/addStudent")
    public String  addStudent (@RequestBody Student student)
    {
        studentService.addStudent(student);
        return student.getName() + " Student added Successfully";
    }

    @PostMapping("/addStudentDTO")
    public String  addStudentDto (@RequestBody StudentRequestDTO studentRequestDTO)
    {
        studentService.addStudentDto(studentRequestDTO);
        return studentRequestDTO.getName() + " Student added Successfully";
    }

    @GetMapping("/findStudentByEmail/")
    public String  findStudentByEmail (@RequestParam("email") String emailId)
    {
        String name = studentService.findStudentByEmail(emailId);
        return "Student Name is: " + name + " for particular emailId: "+ emailId;
    }


    @PutMapping("/updateEmail")
    public StudentResponseDTO updateEmail (@RequestBody StudentUpdateEmail_RequestDTO studentUpdateMobRequestDTO)
    {
        return studentService.updateEmail(studentUpdateMobRequestDTO);
    }
}
