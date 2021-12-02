package com.example.usermicroservice.controller;


import com.example.usermicroservice.exception.IncorrectIdException;
import com.example.usermicroservice.exception.ListIsEmptyException;
import com.example.usermicroservice.model.Order;
import com.example.usermicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final OrderService orderService;

	@GetMapping("/foruser")
	public String getMessage(@RequestHeader Map headers) {
		headers.forEach((key, value) -> System.out.println(key + " : " + value));
		return "Hmm.. Page for user.";
	}

	@GetMapping("/orders")
	public List<Order> read() throws ListIsEmptyException {
		return orderService.readAll();
	}

	@PostMapping("/orders")
	public Order create(@RequestBody Order order) {
		return orderService.create(order);
	}

	@DeleteMapping("/orders/{id}")
	public void delete(@PathVariable("id") Long id) throws IncorrectIdException{
		orderService.delete(id);
	}
}
