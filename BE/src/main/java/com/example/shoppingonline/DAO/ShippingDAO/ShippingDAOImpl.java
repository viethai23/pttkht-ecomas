package com.example.shoppingonline.DAO.ShippingDAO;

import com.example.shoppingonline.DTO.ShippingResponse;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Shipping;

import com.example.shoppingonline.Repository.OrderRepository;
import com.example.shoppingonline.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShippingDAOImpl implements ShippingDAO {

	private final ShippingRepository shippingRepository;

	@Autowired
	public ShippingDAOImpl(ShippingRepository shippingRepository) {
		this.shippingRepository = shippingRepository;
	}

	@Override
	public ShippingResponse calculateCost(Shipping s) {
		s.setAmount(0);
		s.setStatus("order");
		ShippingResponse sp = new ShippingResponse();
		sp.setAmount(s.getAmount());
		sp.setStatus(s.getStatus());
		sp.setMethod(s.getMethod());
		sp.setShippingAddress(s.getShippingAddress());
		sp.setReceiverPhone(s.getReceiverPhone());
		return sp;
	}

}