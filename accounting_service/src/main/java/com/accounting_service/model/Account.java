package com.accounting_service.model;

import Jakarta.persistence.Table;

import java.lang.annotation.Inherited;

import Jakarta.persistence.Entity;
import Jakarta.persistence.Id;
import Lombok.Data;
import Lombok.Builder;

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
