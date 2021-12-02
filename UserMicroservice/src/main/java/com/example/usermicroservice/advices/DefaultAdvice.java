package com.example.usermicroservice.advices;

import com.example.usermicroservice.exception.IncorrectIdException;
import com.example.usermicroservice.exception.ListIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultAdvice {

	@ExceptionHandler(ListIsEmptyException.class)
	public ResponseEntity<String> handlerException(ListIsEmptyException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectIdException.class)
	public ResponseEntity<String> handlerException(IncorrectIdException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
	}
}
