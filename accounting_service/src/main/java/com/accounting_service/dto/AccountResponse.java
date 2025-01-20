package com.accounting_service.dto;


import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
@Builder
public class AccountResponse {
    private String id;
    private Double balance;
    private Integer studentId;
}
