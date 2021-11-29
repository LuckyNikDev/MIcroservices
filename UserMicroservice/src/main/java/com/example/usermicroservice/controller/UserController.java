package com.example.usermicroservice.controller;


import com.example.usermicroservice.exception.IncorrectIdException;
import com.example.usermicroservice.exception.ListIsEmptyException;
import com.example.usermicroservice.model.Order;
import com.example.usermicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Order>> read() throws ListIsEmptyException {
		final List<Order> orders = orderService.readAll();
		if (orders.isEmpty()) {
			throw new ListIsEmptyException("List is empty");
		} else {
			return new ResponseEntity<>(orders, HttpStatus.OK);
		}
	}

	@PostMapping("/orders")
	public ResponseEntity<?> create(@RequestBody Order order) {
		orderService.create(order);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws IncorrectIdException {
		boolean deleted = orderService.delete(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new IncorrectIdException("Please, enter the correct id");
		}
	}
}
