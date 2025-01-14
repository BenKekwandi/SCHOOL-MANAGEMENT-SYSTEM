package com.system.User_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.User_service.model.User;


public interface UserRepository extends JpaRepository<User, String>{
    
    
}

