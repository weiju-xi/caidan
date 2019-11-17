package com.caidan.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caidan.client.QuartzClient;
import com.caidan.result.TableDataInfo;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public QuartzClient quartzClient;
	
	@GetMapping("/quartzs/list")
	public TableDataInfo<?> listQuartzs(){
		TableDataInfo<?> list = quartzClient.list();
		return list;
	}
}
