package com.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.payment_service.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment, String>{
    
    
}

