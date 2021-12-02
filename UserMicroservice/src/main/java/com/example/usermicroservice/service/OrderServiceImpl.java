package com.example.usermicroservice.service;

import com.example.usermicroservice.exception.IncorrectIdException;
import com.example.usermicroservice.exception.ListIsEmptyException;
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
	boolean isInit = false;


	@Override
	public void refreshCache() {
		cache = orderRepository.findAll();
	}

	private void initCache() {
		cache = orderRepository.findAll();
		isInit = true;
	}

	@Override
	public List<Order> readAll() throws ListIsEmptyException {
		if (!isInit) {
			this.initCache();
		}
		if (cache.isEmpty()) {
			throw new ListIsEmptyException("List is empty");
		}
		return cache;
	}



	@Override
	public Order create(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void delete(long id) throws IncorrectIdException {
		if (orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
		} else {
			throw new IncorrectIdException("Please, enter the correct id");
		}
	}
}
