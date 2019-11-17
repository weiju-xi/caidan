package com.caidan.controller;

import java.util.List;

import javax.swing.text.StyleConstants.ColorConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caidan.pojo.model.CustomScheduler;
import com.caidan.pojo.vo.CustomSchedulerVO;
import com.caidan.result.AjaxResult;
import com.caidan.result.Constant;
import com.caidan.result.TableDataInfo;
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
	
	@PostMapping("/update/${name}/{groupName}")
	public AjaxResult<CustomSchedulerVO> pauseJob(@PathVariable("name")String name, @PathVariable("groupName")String groupName) throws Exception{
		
		quartzService.pauseJob(name, groupName);
		
		return new AjaxResult<CustomSchedulerVO>(Constant.OK, "任务已暂停！");
		
	}
	
	@GetMapping("/list")
	public TableDataInfo<CustomSchedulerVO> list() throws Exception{
		List<CustomSchedulerVO> dataList = quartzService.findAllQuartzs();
		
		return new TableDataInfo<CustomSchedulerVO>(dataList, dataList.size());
	}
	
	@DeleteMapping("/del/${jobName}/{groupName}")
	public AjaxResult<?> del(@PathVariable("jobName")String jobName, @PathVariable("groupName")String groupName){
		quartzService.deleteJob(jobName, groupName);
		return new AjaxResult<String>().success("任务已删除！");
	}
	
}
