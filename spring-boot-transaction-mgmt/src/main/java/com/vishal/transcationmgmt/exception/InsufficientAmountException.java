package com.vishal.transcationmgmt.exception;

public class InsufficientAmountException extends RuntimeException{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -5256956287301283313L;

	public InsufficientAmountException(String msg){
	        super(msg);
	    }
}
