package com.irctc.exception;

public class PassengerNotFoundException extends RuntimeException {

	private String msg;

	public PassengerNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
