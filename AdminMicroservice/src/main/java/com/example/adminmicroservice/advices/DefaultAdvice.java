package com.example.adminmicroservice.advices;

import com.example.adminmicroservice.exception.IncorrectIdException;
import com.example.adminmicroservice.exception.ListIsEmptyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

	@ExceptionHandler(ListIsEmptyException.class)
	public String handlerException(ListIsEmptyException e) {
		return e.getMessage();
	}

	@ExceptionHandler(IncorrectIdException.class)
	public String handlerException(IncorrectIdException e) {
		return e.getMessage();
	}
}
