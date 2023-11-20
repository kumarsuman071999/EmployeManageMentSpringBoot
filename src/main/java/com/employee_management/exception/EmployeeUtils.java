package com.employee_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeUtils {
	
	private EmployeeUtils() {
		
	}
	
	public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpStatus){
		return new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}",httpStatus);
	}
	


}
