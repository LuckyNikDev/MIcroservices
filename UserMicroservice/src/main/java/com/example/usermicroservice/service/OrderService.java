package com.example.usermicroservice.service;

import com.example.usermicroservice.exception.IncorrectIdException;
import com.example.usermicroservice.exception.ListIsEmptyException;
import com.example.usermicroservice.model.Order;

import java.util.List;

public interface OrderService {
	void refreshCache();
	List<Order> readAll() throws ListIsEmptyException;
	Order create(Order order);
	void delete(long id) throws IncorrectIdException;
}
