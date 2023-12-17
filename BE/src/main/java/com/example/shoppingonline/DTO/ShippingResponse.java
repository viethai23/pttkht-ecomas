package com.example.shoppingonline.DTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ShippingResponse {
    private String method;

    private String status;

    private double amount;

    private String shippingAddress;

    private String receiverPhone;
}
