package com.utils;

public class WebException extends Exception {
	
	
	public enum ExceptionType{
		ELEMENT_NOT_FOUND, 
		ELEMENT_NOT_CLICKABLE, 
		PAGE_LOAD_TIMEOUT, 
		ACTION_FAILED, INVALID_INPUT, 
		FRAME_NOT_FOUND,
		ALERT_NOT_PRESENT
		
	}
	
	
	private ExceptionType type;
	public WebException(ExceptionType type,String message) {
		super(message);
		this.type = type;

	}
	
	public ExceptionType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "WebExceptions{" + "type=" + type + ", message=" + getMessage() + '}';

	}
	
	

}
