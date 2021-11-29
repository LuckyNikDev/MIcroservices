package com.example.usermicroservice.service;

import com.example.usermicroservice.model.Order;

import java.util.List;

public interface OrderService {
	void refreshCache();
	List<Order> readAll();
	void create(Order order);
	boolean delete(long id);
}
