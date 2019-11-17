package com.caidan.pojo.vo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "定时任务信息")
@Table(name = "qrtz_custom_scheduler")
@Entity
public class CustomSchedulerVO {

	@ApiModelProperty(value = "主键")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schedulerId;
	@ApiModelProperty(value = "任务名称")
	private String jobName;
	@ApiModelProperty(value = "任务分组")
	private String groupName;
	@ApiModelProperty(value = "调度定时任务类全名")
	private String className;
	@ApiModelProperty(value = "转台编码", allowableValues = "1,2,3")
	private Short statusCode;
	@ApiModelProperty(value = "cron表达式")
	private String cronExpression;
	@ApiModelProperty(value = "描述")
	private String description;
	
	private String createUser;
	
	private Date createTime;
	
	private String updateUser;
	
	private Date updateTime;

	public Long getSchedulerId() {
		return schedulerId;
	}

	public void setSchedulerId(Long schedulerId) {
		this.schedulerId = schedulerId;
	}


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Short getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Short statusCode) {
		this.statusCode = statusCode;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
