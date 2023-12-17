package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.OrderDAO.OrderDAO;
import com.example.shoppingonline.Model.Order.Cart;
import com.example.shoppingonline.Model.Order.Order;
import com.example.shoppingonline.Model.Order.Payment;
import com.example.shoppingonline.Model.Order.Shipping;
import com.example.shoppingonline.Model.User.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @PostMapping("/confirm-order")
    public Order confirmOrder(@RequestBody Order order) {
        return orderDAO.confirmOrder(order);
    }

    @GetMapping("/customer-orders")
    public List<Order> getCustomerOrders(@RequestBody Customer customer) {
        return orderDAO.getCustomerOrder(customer);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        return orderDAO.getOrder(orderId);
    }

    @PostMapping("/cancel-order")
    public boolean cancelOrder(@RequestBody Order order) {
        return orderDAO.cancelOrder(order);
    }

    @GetMapping("/all-orders")
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrder();
    }

    @GetMapping("/shipping/{orderId}")
    public Shipping getShipping(@PathVariable int orderId) {
        return orderDAO.getShipping(orderId);
    }

    @GetMapping("/payment/{orderId}")
    public Payment getPayment(@PathVariable int orderId) {
        return orderDAO.getPayment(orderId);
    }

    @GetMapping("/customer/{orderId}")
    public Customer getCustomer(@PathVariable int orderId) {
        return orderDAO.getCustomer(orderId);
    }

    @GetMapping("/cart/{orderId}")
    public Cart getCart(@PathVariable int orderId) {
        return orderDAO.getCart(orderId);
    }
}
