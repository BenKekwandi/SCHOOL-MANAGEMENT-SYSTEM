package com.accounting_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accounting_service.dto.AccountRequest;
import com.accounting_service.dto.AccountResponse;
import com.accounting_service.model.Account;
import com.accounting_service.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Slf4j
@Service
public class AccountService{

    private final AccountRepository AccountRepository;

    public List<AccountResponse> getAllAccounts(){

        List<Account> accounts = AccountRepository.findAll();
        return accounts.stream().map(this::mapToAccountResponse).toList();
        
    }

    public void getAccount(){

    }


    public Account createAccount(AccountRequest request){
        Account account = Account.builder()
            .studentId(request.getStudentId())
            .balance(request.getBalance())
            .build();
        AccountRepository.save(account);
        return account;
    }

    public void editAccount(AccountRequest request){

    }

    public void deleteAccount(){
        
    }

    public AccountResponse mapToAccountResponse(Account Account){
        return AccountResponse.builder()
        .studentId(Account.getStudentId())
        .balance(Account.getBalance())
        .build();
    }
}