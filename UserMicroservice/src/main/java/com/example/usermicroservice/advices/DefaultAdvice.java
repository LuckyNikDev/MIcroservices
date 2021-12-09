package com.example.usermicroservice.advices;

import com.example.usermicroservice.exception.IncorrectIdException;
import com.example.usermicroservice.exception.ListIsEmptyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
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
