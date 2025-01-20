package com.class_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.class_service.model.Class;


public interface ClassRepository extends JpaRepository<Class, String>{
    
    
}

