package com.he.springmvc.valid.exception;

public class ValidException extends Exception {

	private static final long serialVersionUID = -9087950102812085557L;
	
	public ValidException() {

	}

	public ValidException(String msg) {
		super(msg);
	}

	public ValidException(String msg, Exception e) {
		super(msg, e);
	}

}
