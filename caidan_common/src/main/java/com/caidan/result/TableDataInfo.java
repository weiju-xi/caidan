package com.caidan.result;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
   * 表格分页数据对象
 * 
 */
@ApiModel(description = "返回响应数据结果-分页")
public class TableDataInfo<T> implements Serializable {
	
	private static final long serialVersionUID = 4952399816094509907L;

	@ApiModelProperty(value = "状态码：10000  成功,20000 请求参数错误,30000 未登录,40000 没有权限,50000 系统异常,60000数据验证错误")
	public int code;
	
	@ApiModelProperty(value = "总记录数")
	private int total;
	
	@ApiModelProperty(value = "返回列表数据")
	private List<T> dataList;

	/**
	 * 分页
	 * @param list  列表数据
	 * @param total 总记录数
	 */
	public TableDataInfo(List<T> dataList, int total) {
		this.code = Constant.OK;
		this.dataList = dataList;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
