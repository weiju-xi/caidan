package com.caidan.result;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * web统一返回结果类
 */
@ApiModel(description = "返回响应数据结果")
public class AjaxResult<T> implements Serializable{

	private static final long serialVersionUID = -7690071120257480657L;

	@ApiModelProperty(value = "状态码：10000  成功,20000 请求参数错误,30000 未登录,40000 没有权限,50000 系统异常,60000数据验证错误")
	public int code;

	@ApiModelProperty(value = "提示信息")
	public String msg;

	@ApiModelProperty(value = "返回对象")
	public T data;
	
	public AjaxResult() {
	}
	
	public AjaxResult(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public AjaxResult(int code,String msg,T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 返回成功消息
	 * 
	 * @return 成功消息
	 */
	public static AjaxResult<?> success() {
		return new AjaxResult<Object>(Constant.OK,"操作成功！");
	}

	/**
	 * 返回成功消息
	 * @param msg 返回内容
	 * @return 成功消息
	 */
	public static AjaxResult<?> success(String msg) {
		return new AjaxResult<Object>(Constant.OK,msg);
	}
	
	/**
	 * 返回成功消息
	 * @param data 数据对象
	 * @return 成功消息
	 */
	public static <T> AjaxResult<T> success(T data) {
		return new AjaxResult<T>(Constant.OK,"操作成功！",data);
	}
	
	/**
	 * 返回成功消息
	 * @param msg 返回内容
	 * @param data 数据对象
	 * @return 成功消息
	 */
	public static <T> AjaxResult<T> success(String msg,T data) {
		return new AjaxResult<T>(Constant.OK,msg,data);
	}

	/**
	 * 返回失败消息
	 * 
	 * @return 失败消息
	 */
	public static AjaxResult<?> error() {
		return new AjaxResult<Object>(Constant.INTERNAL_SERVER_ERROR,"系统异常！");
	}
	
	/**
	 * 返回失败消息
	 * @param msg 返回内容
	 * @return 失败消息
	 */
	public static AjaxResult<?> error(String msg) {
		return new AjaxResult<Object>(Constant.INTERNAL_SERVER_ERROR,msg);
	}
	
	/**
	 * 返回失败消息
	 * @param msg 返回内容
	 * @param data 数据对象
	 * @return 失败消息
	 */
	public static <T> AjaxResult<T> error(String msg,T data) {
		return new AjaxResult<T>(Constant.INTERNAL_SERVER_ERROR,msg,data);
	}
	
	/**
	 * 未登录
	 * @param msg 返回内容
	 * @return 失败消息
	 */
	public static AjaxResult<?> noLogin(String msg) {
		return new AjaxResult<Object>(Constant.UNAUTHORIZED,msg);
	}
	
	/**
	 * 没有权限
	 * @param msg 返回内容
	 * @return 失败消息
	 */
	public static AjaxResult<?> noPrivileges(String msg) {
		return new AjaxResult<Object>(Constant.FORBIDDEN,msg);
	}
	
	/**
	 * 请求参数错误
	 * @param msg 返回内容
	 * @return 失败消息
	 */
	public static AjaxResult<?> badRequest(String msg) {
		return new AjaxResult<Object>(Constant.BAD_REQUEST,msg);
	}
	
	/**
	 * 数据校验错误
	 * @param msg 返回内容
	 * @return 失败消息
	 */
	public static AjaxResult<?> validFail(String msg) {
		return new AjaxResult<Object>(Constant.VALID_FAIL,msg);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
