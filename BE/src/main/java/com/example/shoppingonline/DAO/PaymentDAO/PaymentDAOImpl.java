package com.example.shoppingonline.DAO.PaymentDAO;

import com.example.shoppingonline.DTO.PaymentResponse;
import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Payment;
import com.example.shoppingonline.Model.Order.Shipping;

import com.example.shoppingonline.Repository.OrderRepository;
import com.example.shoppingonline.Repository.PaymentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	private final PaymentRepository paymentRepository;


	@Autowired
	public PaymentDAOImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public PaymentResponse calculateCost(Cart c, Shipping sh, Payment p) {
		p.setStatus("order");
		p.setAmount(c.getTotal() + sh.getAmount());
		PaymentResponse pm = new PaymentResponse();
		pm.setAmount(p.getAmount());
		pm.setPaymentMethod(p.getPaymentMethod());
		pm.setPaymentDate(p.getPaymentDate());
		pm.setStatus(p.getStatus());
		return pm;
	}

	@Override
	public boolean processPayment(Payment p) {
		p.setStatus("Successful");
		paymentRepository.save(p);
		return true;
	}
}