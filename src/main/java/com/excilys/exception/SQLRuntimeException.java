package com.excilys.exception;

import java.util.Arrays;

public class SQLRuntimeException extends RuntimeException {
	private final static String error="SQL error : ";
	public SQLRuntimeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SQLRuntimeException(String message,StackTraceElement[] stack) {
		super(error+message);
		this.setStackTrace(stack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return new StringBuilder("SQLRuntimeException [errMsg=").append(this.getMessage()).append(
				" stack ").append(Arrays.toString(this.getStackTrace())).append("]").toString();
	}
	
	
}
