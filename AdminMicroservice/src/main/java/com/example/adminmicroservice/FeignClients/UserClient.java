package com.example.adminmicroservice.FeignClients;


import com.example.adminmicroservice.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user", url = "http://user-micro:8082/")
public interface UserClient {
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	List<Order> read();

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	Order create(@RequestBody Order order);

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") Long id);
}
