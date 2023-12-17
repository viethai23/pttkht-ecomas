package com.example.shoppingonline.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentResponse {
    private double amount;

    private Date paymentDate;

    private String paymentMethod;

    private String status;
}
