package com.example.shoppingonline.Model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shipping")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "method")
	private String method;

	@Column(name = "status")
	private String status;

	@Column(name = "amount")
	private double amount;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "receiver_phone")
	private String receiverPhone;
}