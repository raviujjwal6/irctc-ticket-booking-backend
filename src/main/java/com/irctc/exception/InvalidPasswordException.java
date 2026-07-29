package com.irctc.exception;

public class InvalidPasswordException extends RuntimeException {

	private String msg;

	public InvalidPasswordException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
