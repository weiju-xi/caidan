package com.caidan.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DemoJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("当前时间为---------"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
