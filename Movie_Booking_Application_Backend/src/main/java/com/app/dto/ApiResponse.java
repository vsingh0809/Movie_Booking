package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
	private LocalDateTime timestamp;
	private String message;
	
	public ApiResponse(String message) {
		this.message = message;
		this.timestamp=LocalDateTime.now();
	}
	
}
