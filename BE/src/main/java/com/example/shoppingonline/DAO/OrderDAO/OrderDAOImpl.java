package com.example.shoppingonline.DAO.OrderDAO;

import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Payment;
import com.example.shoppingonline.Model.Order.Shipping;
import com.example.shoppingonline.Model.User.Customer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.example.shoppingonline.Repository.CartRepository;
import com.example.shoppingonline.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAOImpl implements OrderDAO {

	private OrderRepository orderRepository;

	private CartRepository cartRepository;

	public OrderDAOImpl(OrderRepository orderRepository, CartRepository cartRepository) {
		this.orderRepository = orderRepository;
		this.cartRepository = cartRepository;
	}

	@Override
	public Order confirmOrder(Order order) {
		order.getShipping().setStatus("ordered");
		order.getPayment().setStatus("ordered");
		LocalDateTime localDateTime = LocalDateTime.now();
		Date curentTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		order.setOrderDate(curentTime);
		Cart cart = cartRepository.findById(order.getCart().getId()).orElse(null);
		if(cart != null) {
			cart.setStatus("ordered");
			cartRepository.save(cart);
		}
		order.setTotalAmount(order.getPayment().getAmount());
		order.setStatus("confirmed");
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getCustomerOrder(Customer c) {
		return orderRepository.findByCustomer(c);
	}

	@Override
	public Order getOrder(int id) {
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public boolean cancelOrder(Order order) {
		orderRepository.delete(order);
		return true;
	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	public Shipping getShipping(int orderId) {
		return getOrder(orderId).getShipping();
	}

	@Override
	public Payment getPayment(int orderId) {
		return getOrder(orderId).getPayment();
	}

	@Override
	public Customer getCustomer(int orderId) {
		return getOrder(orderId).getCustomer();
	}

	@Override
	public Cart getCart(int orderId) {
		return getOrder(orderId).getCart();
	}
}