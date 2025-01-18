package com.accounting_service.repository;


import org.springframework.data.jpa.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String>{
    
}
