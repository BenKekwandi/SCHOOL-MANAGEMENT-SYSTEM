package com.accounting_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounting_service.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
    Account findByStudentId(Integer studentId);
}
