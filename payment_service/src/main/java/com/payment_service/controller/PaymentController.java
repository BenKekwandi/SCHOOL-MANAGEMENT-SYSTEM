package com.payment_service.controller;

import com.payment_service.dto.PaymentRequest;
import com.payment_service.dto.PaymentResponse;
import com.payment_service.model.Payment;
import com.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/payment")
public class PaymentController{

    private final PaymentService paymentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponse> index(){
       return paymentService.getAllPayments();
    }

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public void show(){
    //     paymentService.getPayment();
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment store(@RequestBody PaymentRequest request){
        return paymentService.createPayment(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody PaymentRequest request){
        paymentService.editPayment(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void destroy(){
        paymentService.deletePayment();
    }

}