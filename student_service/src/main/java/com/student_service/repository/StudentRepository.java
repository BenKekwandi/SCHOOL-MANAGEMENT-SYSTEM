package com.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student_service.model.Student;


public interface StudentRepository extends JpaRepository<Student, String>{
    
    
}

