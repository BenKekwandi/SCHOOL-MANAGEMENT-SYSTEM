package com.class_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.class_service.model.ClassModel;


public interface ClassRepository extends JpaRepository<ClassModel, Integer>{
    
    
}

