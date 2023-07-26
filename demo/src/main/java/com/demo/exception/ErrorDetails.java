package com.demo.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {

	private String details;
	private String description;
	private LocalDateTime timeStamp;
	
}
