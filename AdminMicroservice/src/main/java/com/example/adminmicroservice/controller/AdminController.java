package com.example.adminmicroservice.controller;

import com.example.adminmicroservice.FeignClients.UserClient;
import com.example.adminmicroservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final UserClient userClient;

    @GetMapping("/orders")
    public List<Order> read() {
        return userClient.read();
    }

    @PostMapping("/orders")
    public Order create(@RequestBody Order order) {
        return userClient.create(order);
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable("id") Long id) {
        userClient.delete(id);
    }
}
