package com.accounting_service.dto;

import Jakarta.persistence.Table;

import java.lang.annotation.Inherited;

import Lombok.Data;
import Lombok.Builder;
import Lombok.AllArgsConstructor;
import Lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
@Builder
public class AccountRequest {
    private String id;
    private Double balance;
    private Integer studentId;
}
