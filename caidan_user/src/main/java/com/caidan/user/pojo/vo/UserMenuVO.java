package com.caidan.user.pojo.vo;

import java.io.Serializable;

public class UserMenuVO implements Serializable{

	private static final long serialVersionUID = 8988068338247679233L;

	private String name;
	
	private Integer parentId;
	
	private String url;
	
	private Integer level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
