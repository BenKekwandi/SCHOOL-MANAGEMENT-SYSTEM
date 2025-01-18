package com.class_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.course_service.model.Course;


public interface ClassRepository extends JpaRepository<Class, String>{
    
    
}

