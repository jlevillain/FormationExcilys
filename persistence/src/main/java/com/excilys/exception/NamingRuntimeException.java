package com.excilys.exception;

import java.util.Arrays;

/**
 * Exception for the name of directory
 * @author jlevillain
 *
 */
public class NamingRuntimeException extends Error {
	private final static String error="SQL error : ";
	private String errMsg;
	
	/**
	 * constructor of exception
	 * @param message message of the exception
	 * @param stack stack of the exception
	 */
	public NamingRuntimeException(String message,StackTraceElement[] stack) {
		super(error+message);
		this.setStackTrace(stack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		this.printStackTrace();
		return new StringBuilder("SQLRuntimeException [errMsg=").append(errMsg).append(
				" stack ").append(Arrays.toString(this.getStackTrace())).append("]").toString();
	}
}
