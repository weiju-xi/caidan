package com.caidan.user.pojo.vo;

import java.io.Serializable;
import java.util.List;

public class UserMenuVO implements Serializable{

	private static final long serialVersionUID = 8988068338247679233L;

	private Integer id;
	
	private String name;
	
	private Integer parentId;
	
	private String url;
	
	private Integer level;
	
	private List<UserMenuVO> children;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<UserMenuVO> getChildren() {
		return children;
	}

	public void setChildren(List<UserMenuVO> children) {
		this.children = children;
	}

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
