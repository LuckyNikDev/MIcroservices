package com.example.adminmicroservice.controller;

import com.example.adminmicroservice.FeignClients.UserClient;
import com.example.adminmicroservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final UserClient userClient;

    @GetMapping("/foradmin")
    public String getMessage(@RequestHeader Map headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return "Congrate! You are admin.";
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> read() {
        return userClient.read();
    }

    @PostMapping("/orders")
    public ResponseEntity<?> create(@RequestBody Order order) {
        return userClient.create(order);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return userClient.delete(id);
    }
}
