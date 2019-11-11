package com.caidan.execption;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message)
	{
		super(message);
	}
	
	public BusinessException(String errorcode,String message)
	{
		super(errorcode+message);
	}

	public BusinessException(String message, Throwable t) {
		super(message, t);
	}

	public BusinessException(Throwable t) {
		super(t);
	}
}
