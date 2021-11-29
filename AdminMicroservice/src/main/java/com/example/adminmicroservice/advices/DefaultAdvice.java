package com.example.adminmicroservice.advices;

import com.example.adminmicroservice.exception.IncorrectIdException;
import com.example.adminmicroservice.exception.ListIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

	@ExceptionHandler(ListIsEmptyException.class)
	public ResponseEntity<?> handlerException(ListIsEmptyException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectIdException.class)
	public ResponseEntity<?> handlerException(IncorrectIdException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
	}
}
