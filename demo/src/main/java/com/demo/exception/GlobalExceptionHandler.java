package com.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exc1 (Exception ex , WebRequest req)
	{
		ErrorDetails er = new ErrorDetails();
		er.setDetails(ex.getMessage());
		er.setDescription(req.getDescription(false));
		er.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(FlatException.class)
	public ResponseEntity<ErrorDetails> exc2 (FlatException ex , WebRequest req)
	{
		ErrorDetails er = new ErrorDetails();
		er.setDetails(ex.getMessage());
		er.setDescription(req.getDescription(false));
		er.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> exc3 (MethodArgumentNotValidException ex , WebRequest req)
	{
		ErrorDetails er = new ErrorDetails();
		er.setDetails(ex.getMessage());
		er.setDescription(req.getDescription(false));
		er.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> exc4 (NoHandlerFoundException ex , WebRequest req)
	{
		ErrorDetails er = new ErrorDetails();
		er.setDetails(ex.getMessage());
		er.setDescription(req.getDescription(false));
		er.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
