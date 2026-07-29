package com.irctc.exception;

public class TrainNotFoundException extends RuntimeException{

	private String msg;

	public TrainNotFoundException(String msg) {
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}
	
}
