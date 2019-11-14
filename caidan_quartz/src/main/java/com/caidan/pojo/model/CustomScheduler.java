package com.caidan.pojo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "定时任务信息")
@Table(name = "qutz_custom_scheduler")
@Entity
public class CustomScheduler {

	@ApiModelProperty(value = "主键")
	@Id
	private Long schedulerId;
	@ApiModelProperty(value = "任务名称")
	private String name;
	@ApiModelProperty(value = "任务分组")
	private String group;
	@ApiModelProperty(value = "调度定时任务类全名")
	private String className;
	@ApiModelProperty(value = "转台编码", allowableValues = "1,2,3")
	private Short status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
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
