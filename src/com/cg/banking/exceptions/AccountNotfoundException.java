package com.cg.banking.exceptions;

@SuppressWarnings("serial")
public class AccountNotfoundException extends Exception{

	public AccountNotfoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountNotfoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountNotfoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountNotfoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountNotfoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
