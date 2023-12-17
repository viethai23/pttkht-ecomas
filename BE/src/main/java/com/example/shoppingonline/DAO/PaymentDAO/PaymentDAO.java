package com.example.shoppingonline.DAO.PaymentDAO;

import com.example.shoppingonline.DTO.PaymentResponse;
import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Payment;
import com.example.shoppingonline.Model.Order.Shipping;

public interface PaymentDAO {

	PaymentResponse calculateCost(Cart c, Shipping sh, Payment p);

	boolean processPayment(Payment p);
}