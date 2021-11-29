package com.example.usermicroservice.service;

import com.example.usermicroservice.model.Order;
import com.example.usermicroservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;
	private List<Order> cache = new ArrayList<>();

	@Override
	public void refreshCache() {
		cache = orderRepository.findAll();
	}

	@Override
	public List<Order> readAll() {
		return cache;
	}

	@Override
	public void create(Order order) {
		orderRepository.save(order);
	}

	@Override
	public boolean delete(long id) {
		if (orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
