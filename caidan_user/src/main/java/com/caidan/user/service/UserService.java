package com.caidan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caidan.user.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	
}
