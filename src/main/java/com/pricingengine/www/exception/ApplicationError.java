package com.pricingengine.www.exception;

public class ApplicationError extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum ErrorType {
		badRequest, serverError, functionalError, securityError
	}
	
	
	private String errorId;
	
	public String getErrorId() {
		return errorId;
	}
	
	public ApplicationError(ErrorType errorType, String errorIdSuffix, String errorMessage) {
		super(errorMessage);
		this.errorId = generateErrorId(errorType, errorIdSuffix);
	}
	
	public ApplicationError(ErrorType errorType, String errorIdSuffix, String errorMessage, Throwable e) {
		super(errorMessage, e);
		this.errorId = generateErrorId(errorType, errorIdSuffix);
	}
	
	public ApplicationError(ErrorType errorType, String errorId, Exception e) {
		super(e);
		this.errorId = generateErrorId(errorType, errorId);
	}

	private String generateErrorId(ErrorType errorType, String errorIdSuffix) {
		if(errorType != null && errorIdSuffix == null)
			return errorType.toString();
		else if(errorType == null && errorIdSuffix != null)
			return errorIdSuffix.toString();
		else if(errorType != null && errorIdSuffix != null)
			return errorType.toString() + "|" + errorIdSuffix.toString();
		return "";
	}

	public String getUserMessage() {
		return super.getMessage();
	}

}
