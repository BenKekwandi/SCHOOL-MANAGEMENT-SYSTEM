package com.accounting_service.service;


import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.accounting_service.dto.AccountRequest;
import com.accounting_service.dto.AccountResponse;
import com.accounting_service.dto.PaymentEvent;
import com.accounting_service.model.Account;
import com.accounting_service.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;


@RequiredArgsConstructor
@Slf4j
@Service
public class AccountService{

    private final AccountRepository accountRepository;

    public List<AccountResponse> getAllAccounts(){

        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(this::mapToAccountResponse).toList();
        
    }

    public void getAccount(){

    }


    public Account createAccount(AccountRequest request){
        Account account = Account.builder()
            .studentId(request.getStudentId())
            .balance(request.getBalance())
            .build();
        accountRepository.save(account);
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

    @KafkaListener(topics = "payment-topic", groupId = "accounting-group")
    public void consumePaymentEvent(PaymentEvent paymentEvent) {
        System.out.println("Consumed payment event: " + paymentEvent);
        updateStudentBalance(paymentEvent);
    }

    private void updateStudentBalance(PaymentEvent paymentEvent) {
        Account account = accountRepository.findByStudentId(paymentEvent.getStudentId());
        if (account != null) {
            account.setBalance(account.getBalance() + paymentEvent.getAmount());
            accountRepository.save(account);
            System.out.println("Account balance updated: " + account.getBalance());
            return;
        }
        System.out.println("Account not found for studentId: " + paymentEvent.getStudentId());
    }
}