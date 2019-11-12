package com.caidan.service.impl;


import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caidan.dao.CustomerSchedulerDao;
import com.caidan.pojo.model.CustomScheduler;
import com.caidan.service.IQuartzService;

import java.util.Map;

/**
 * @description: 任务调度服务接口实现类
 */
@Service
public class QuartzServiceImpl implements IQuartzService {

    @Autowired
    Scheduler scheduler;
    
    @Autowired
    CustomerSchedulerDao customeSchedulerDao;


    /**
     * 创建job，可传参
     *
     * @param clazz     任务类
     * @param name      任务名称
     * @param groupName 任务所在组名称
     * @param cronExp   cron表达式
     * @param param     map形式参数
     */
    @Override
    public void addJob(Class clazz, String name, String groupName, String cronExp, Map<String, Object> param) {
        try {
            // 启动调度器
            scheduler.start();
            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(((Job) clazz.newInstance()).getClass()).withIdentity(name, groupName).build();
            //表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExp);
            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, groupName).withSchedule(scheduleBuilder).build();
            //获得JobDataMap，写入数据
            if (param != null) {
                trigger.getJobDataMap().putAll(param);
            }
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停job
     *
     * @param name      任务名称
     * @param groupName 任务所在组名称
     */
    @Override
    public void pauseJob(String name, String groupName) {
        try {
            scheduler.pauseJob(JobKey.jobKey(name, groupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复job
     *
     * @param name      任务名称
     * @param groupName 任务所在组名称
     */
    @Override
    public void resumeJob(String name, String groupName) {
        try {
            scheduler.resumeJob(JobKey.jobKey(name, groupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * job 更新,更新频率和参数
     *
     * @param name      任务名称
     * @param groupName 任务所在组名称
     * @param cronExp   cron表达式
     * @param param     参数
     */
    @Override
    public void updateJob(String name, String groupName, String cronExp, Map<String, Object> param) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(name, groupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (cronExp != null) {
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExp);
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            }

            //修改map
            if (param != null) {
                trigger.getJobDataMap().putAll(param);
            }
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * job 删除
     *
     * @param name      任务名称
     * @param groupName 任务所在组名称
     */
    @Override
    public void deleteJob(String name, String groupName) {
        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(name, groupName));
            scheduler.unscheduleJob(TriggerKey.triggerKey(name, groupName));
            scheduler.deleteJob(JobKey.jobKey(name, groupName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 启动所有定时任务
     */
    @Override
    public void startAllJobs() {
        try {
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭所有定时任务
     */
    @Override
    public void shutdownAllJobs() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public int addJob(CustomScheduler cs) throws Exception{
		
		cs.setStatus((short)1);
		
		CustomScheduler customerScheduler = customeSchedulerDao.saveAndFlush(cs);
		
		addJob(Class.forName(cs.getJob()), cs.getName(), cs.getGroupName(), cs.getCronExp(), null);
		
		return customerScheduler.getStatus().intValue();
	}
}
