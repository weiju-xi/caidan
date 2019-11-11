package com.caidan.execption;

/**
 * 远程服务异常，建议非查询类远程服务接口抛出此异常
 *
 */
public class RemoteServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public RemoteServiceException(String message){
		super(message);
	}
	
	public RemoteServiceException(String errorcode,String message)
	{
		super(errorcode+message);
	}
	
	public RemoteServiceException(Throwable t){
		super(t);
	}
	
	public RemoteServiceException(String message , Throwable t){
		super(message ,t);
	}
	
	@Override
	public synchronized Throwable fillInStackTrace() {
		return null;
	}
	
	
}
