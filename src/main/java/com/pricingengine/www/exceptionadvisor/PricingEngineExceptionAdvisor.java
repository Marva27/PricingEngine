package com.pricingengine.www.exceptionadvisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pricingengine.www.exception.ApplicationError;
import com.pricingengine.www.exception.ErrorMessage;

@ControllerAdvice
public class PricingEngineExceptionAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<ErrorMessage> handleConflict(RuntimeException ex) {
		String errorId = null, userMessage = null;
		HttpStatus status = null;
		if(ex instanceof ApplicationError) {
			errorId = ((ApplicationError) ex).getErrorId();
			userMessage = ((ApplicationError) ex).getUserMessage();
		}
		
		if(errorId.startsWith(ApplicationError.ErrorType.badRequest.toString()))
			status = HttpStatus.BAD_REQUEST;
		if(errorId.startsWith(ApplicationError.ErrorType.serverError.toString()))
			status = HttpStatus.NOT_FOUND;
		if(errorId.startsWith(ApplicationError.ErrorType.functionalError.toString()))
			status = HttpStatus.NOT_IMPLEMENTED;
		
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorId(errorId);
		errorMessage.setErrorMessage(userMessage);
		
		return new ResponseEntity<ErrorMessage>(errorMessage, status);
	}
}
