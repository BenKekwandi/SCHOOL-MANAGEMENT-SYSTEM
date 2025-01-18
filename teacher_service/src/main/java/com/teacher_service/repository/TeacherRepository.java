package com.teacher_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teacher_service.model.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
    
    
}

