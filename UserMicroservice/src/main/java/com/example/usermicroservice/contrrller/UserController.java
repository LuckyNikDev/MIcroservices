package com.example.usermicroservice.contrrller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
	@GetMapping("/foruser")
	public String getMessage(@RequestHeader Map headers) {
		headers.forEach((key, value) -> System.out.println(key + " : " + value));
		return "Hmm.. Page for user.";
	}
}
