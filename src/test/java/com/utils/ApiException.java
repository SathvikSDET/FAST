package com.utils;

public class ApiException extends Exception {
	
	public enum ExceptionType {
		REQUEST_FAILED,
        RESPONSE_TIMEOUT,
        INVALID_STATUS_CODE,
        MALFORMED_RESPONSE,
        AUTHENTICATION_FAILED,
        JSON_PARSING_ERROR,
        HEADER_MISSING,
        INVALID_PAYLOAD
	}
	
	private ExceptionType type;
	
	public ApiException(ExceptionType type,String message) {
		super(message);
		this.type = type;
	}
	
	
	
	@Override
	public String toString() {
		return "API Exception "+ type+" message"+ getMessage() ;
	}
	
	

}
