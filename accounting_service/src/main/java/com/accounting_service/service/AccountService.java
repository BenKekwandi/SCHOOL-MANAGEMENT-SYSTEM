package com.accounting_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.account_service.dto.AccountRequest;
import com.account_service.dto.AccountResponse;
import com.account_service.model.Account;
import com.account_service.repository.AccountRepository;

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
        Account Account = Account.builder()
            .studentId(request.getStudentId())
            .balance(request.getBalance())
            .build();
        AccountRepository.save(Account);
        return Account;
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