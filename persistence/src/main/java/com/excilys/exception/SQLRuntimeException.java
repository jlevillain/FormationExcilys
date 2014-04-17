package com.excilys.exception;

import java.util.Arrays;

/**
 * Exception for sql 
 * @author excilys
 *
 */
public class SQLRuntimeException extends RuntimeException {
	private final static String error="SQL error : ";
	/**
	 * Default constructor of exception
	 */
	public SQLRuntimeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor of exception
	 * @param message message of exception
	 * @param stack stack of exception
	 */
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
