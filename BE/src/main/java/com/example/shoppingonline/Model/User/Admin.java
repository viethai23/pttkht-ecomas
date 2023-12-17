package com.example.shoppingonline.Model.User;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	private String role;
}