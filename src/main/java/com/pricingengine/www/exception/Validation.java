package com.pricingengine.www.exception;

import java.util.Arrays;
import java.util.List;

public class Validation {
	
	public static void ensureFieldValueNotZero(Object value, String fieldId) {
		if((int)value == 0) {
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId, 
					"field " + fieldId + " cannot be zero");
		}
	}
	
	public static void ensureFieldNotNull(Object value, String fieldId) {
		if(value == null || String.valueOf(value).trim().equals("")) {
			throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId + "|unspecified", 
					"field " + fieldId + " is required");
		}
	}
	
	public static void ensureFieldIsOneOf(Object value, String fieldId, List<Object> options) {
		for(Object option : options) {
			if((option == null && value == null) || option.equals(value))
					return;
		}
		throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId + "|unspecified", 
				"field " + fieldId + " must be one of: " + options.toString());
	}
	
	public static void ensureFieldIsOneOf(Object value, String fieldId, Object... options) {
		for(Object option : options) {
			if((option == null && value == null) || option.equals(value))
					return;
		}
		throw new ApplicationError(ApplicationError.ErrorType.badRequest, fieldId + "|unspecified", 
				"field " + fieldId + " must be one of: " + String.join(", ", Arrays.stream(options)
						.map(o -> o == null ? "null" : "'" + o.toString() + "'").toArray(String[]::new)));
	}
	
	public static void ensureObjectNotNull(Object value, String message) {
		if(value == null) {
			throw new ApplicationError(ApplicationError.ErrorType.serverError, message,
					message);
		}
	}

}
