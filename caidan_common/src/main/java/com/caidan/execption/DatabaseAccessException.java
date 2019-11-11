package com.caidan.execption;
/**
 * 数据访问异常
 */
public class DatabaseAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4275939698819165407L;
	
	public DatabaseAccessException(String message){
		super(message);
	}
	
	public DatabaseAccessException(Throwable t){
		super(t);
	}
	
	public DatabaseAccessException(String message , Throwable t){
		super(message ,t);
	}
	
	/**
	 * 为防止在远程传输中影响性能，重载此方法
	 */
	@Override
	public synchronized Throwable fillInStackTrace() {
		
		return null;
	}

}
