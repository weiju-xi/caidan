package com.caidan.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.caidan.user.pojo.User;

public interface UserDao extends JpaRepository<User, String>,JpaSpecificationExecutor<User>{

	public User findByMobile(String mobile);
	
	
	
}
