package com.caidan.execption;

/**
 * @ClassName DataValidException
 * @Description 数据校验异常(代码判断)
 */
public class DataValidException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataValidException(String message) {
		super(message);
	}
	
	public DataValidException(String message, Throwable t) {
		super(message, t);
	}

	public DataValidException(Throwable t) {
		super(t);
	}
}
