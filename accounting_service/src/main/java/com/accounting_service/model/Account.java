package com.accounting_service.model;

import jakarta.persistence.Table;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Builder;

@Table
@Entity
@Data 
@Builder
public class Account {
    @Id
    private String id;
    private Double balance;
    private Integer studentId;
}
