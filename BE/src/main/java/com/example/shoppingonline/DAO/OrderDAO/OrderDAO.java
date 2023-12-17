package com.example.shoppingonline.DAO.OrderDAO;

import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Payment;
import com.example.shoppingonline.Model.Order.Shipping;
import com.example.shoppingonline.Model.User.Customer;

import java.util.Date;
import java.util.List;

public interface OrderDAO {

	Order confirmOrder(Order order);

	List<Order> getCustomerOrder(Customer c);

	Order getOrder(int id);

	boolean cancelOrder(Order o);

	List<Order> getAllOrder();

	Shipping getShipping(int orderId);
	Payment getPayment(int orderId);
	Customer getCustomer(int orderId);
	Cart getCart(int orderId);

}