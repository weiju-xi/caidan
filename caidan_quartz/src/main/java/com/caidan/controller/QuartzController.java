package com.caidan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caidan.pojo.model.CustomScheduler;
import com.caidan.pojo.vo.CustomSchedulerVO;
import com.caidan.result.AjaxResult;
import com.caidan.result.Constant;
import com.caidan.service.IQuartzService;

import io.swagger.annotations.Api;

@Api(tags = "定时任务调度")
@RestController
@RequestMapping("/quartzs")
public class QuartzController {

	@Autowired
	private IQuartzService quartzService;

	@PostMapping("/add")
	public AjaxResult<CustomSchedulerVO> add(@RequestBody CustomScheduler cs) throws Exception{
		
		quartzService.addJob(cs);
		
		return new AjaxResult<CustomSchedulerVO>(Constant.OK, "任务添加成功！");
		
	}
}
