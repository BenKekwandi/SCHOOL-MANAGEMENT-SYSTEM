package com.accounting_service.controller;

import com.accounting_service.dto.AccountRequest;
import com.accounting_service.dto.AccountResponse;
import com.accounting_service.model.Account;
import com.accounting_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/account")
public class AccountController{

    private final AccountService accountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponse> index(){
       return accountService.getAllAccounts();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     accountService.getAccount();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account store(@RequestBody AccountRequest AccountRequest){
        return accountService.createAccount(AccountRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody AccountRequest AccountRequest){
        accountService.editAccount(AccountRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        accountService.deleteAccount();
    }

}