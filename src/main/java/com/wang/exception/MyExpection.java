package com.wang.exception;

public class MyExpection extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -504843891947877996L;
	private String message;
	public MyExpection(String message){
		super(message);
	}
	 
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
