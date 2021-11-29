package com.example.adminmicroservice.model;

import lombok.Data;

@Data
public class Order {
	private Long id;
	private String product_name;
	private int quantity;
}
