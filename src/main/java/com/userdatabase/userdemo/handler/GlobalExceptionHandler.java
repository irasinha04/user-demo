package com.userdatabase.userdemo.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.userdatabase.userdemo.exception.TokenNotActiveException;
import com.userdatabase.userdemo.exception.TokenNotValidException;
import com.userdatabase.userdemo.exception.UserCredentialDuplicateException;
import com.userdatabase.userdemo.exception.UserNotFoundException;
import com.userdatabase.userdemo.model.AccessTokenError;
import com.userdatabase.userdemo.model.AccessUserError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<AccessUserError> userNotFoundError(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<AccessUserError>(AccessUserError.showMessage(ex.getMessage()), null,
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserCredentialDuplicateException.class)
	public ResponseEntity<AccessUserError> userCredentialDuplicateError(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<AccessUserError>(AccessUserError.showMessage(ex.getMessage()), null,
				HttpStatus.CONFLICT);
	}

	@ExceptionHandler(TokenNotActiveException.class)
	public ResponseEntity<AccessTokenError> tokenNotActiveError(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<AccessTokenError>(AccessTokenError.showMessage(ex.getMessage()), null,
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TokenNotValidException.class)
	public ResponseEntity<AccessTokenError> tokenNotValidError(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<AccessTokenError>(AccessTokenError.showMessage(ex.getMessage()), null,
				HttpStatus.FORBIDDEN);
	}
}