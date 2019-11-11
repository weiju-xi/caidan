package com.caidan.execption;

public enum ExceptionCode {
	
	INVALIDATE_PARAM("INVALIDATE_PARAM","无效参数"),
	PARAM_NOT_FOUND("PARAM_NOT_FOUND","未找到参数");
	
	private final String code;
	private final String msg;
	
	ExceptionCode(String code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
