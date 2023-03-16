package com.librarymanagementsystem.libraryManagementSystem.Repository;

import com.librarymanagementsystem.libraryManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
