package com.irctc.exception;

public class BookingNotFoundException extends RuntimeException{
	private String msg;

	public BookingNotFoundException(String msg) {
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
		
	}

}
