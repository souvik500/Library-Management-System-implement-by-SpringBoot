package com.librarymanagementsystem.libraryManagementSystem.Repository;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    /**
     * This is Custom Query for Specific Attributes like Here email, age
     * @param email which given particular email id based on that Our ORM(Hibernate) implement that
     * @return List of Student Age in 2nd Method;
     */
    Student findByEmail (String email);

    List<Student> findByAge (int age);
}
