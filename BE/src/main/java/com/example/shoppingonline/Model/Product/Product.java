package com.example.shoppingonline.Model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(name = "name")
	private String name;

	@Column(name = "des")
	private String des;

	@Column(name = "price")
	private float price;

	@Column(name = "stock_quantity")
	private int stockQuantity;

	@Column(name = "image")
	private String image;
}