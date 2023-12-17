package com.example.shoppingonline.Model.Order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "amount")
	private double amount;

	@Column(name = "payment_date")
	private Date paymentDate;

	@Column(name = "payment_method")
	private String paymentMethod;

	@Column(name = "status")
	private String status;
}