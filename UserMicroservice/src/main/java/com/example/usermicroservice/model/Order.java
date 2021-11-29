package com.example.usermicroservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String product_name;
	private int quantity;
}
