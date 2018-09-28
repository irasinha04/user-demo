package com.userdatabase.userdemo.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.userdatabase.userdemo.exception.UserNotFoundException;
import com.userdatabase.userdemo.model.AccessUserError;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AccessUserError> userError(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<AccessUserError>(AccessUserError.showMessage(ex.getMessage()), null,
				HttpStatus.BAD_REQUEST);
	}
}