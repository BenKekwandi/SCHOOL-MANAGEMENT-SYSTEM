package com.payment_service.model;

import java.util.Date;

import Lombok.Data;
import Lombok.Builder;
import Jakarta.persistence.Table;
import Jakarta.persistence.Entity;
import Jakarta.persistence.Id;

@Table(name="payments")
@Entity
@Builder
@Data
public class Payment {
    @Id
    private Integer id;
    private Integer studentId;
    private Double Amount;
    private Date PaymentDate;

}
