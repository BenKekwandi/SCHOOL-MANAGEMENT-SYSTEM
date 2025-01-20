package com.payment_service.dto;

import java.util.Date;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentResponse {
    private Integer id;
    private Integer studentId;
    private Double amount;
    private Date paymentDate;

}
