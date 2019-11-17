package com.caidan.service;


import java.util.List;
import java.util.Map;

import com.caidan.pojo.model.CustomScheduler;
import com.caidan.pojo.vo.CustomSchedulerVO;

/**
 * @packageName: com.boot.quartz.service
 * @name: QuartzService
 * @description: 任务操作服务接口层
 */
public interface IQuartzService {
    /**
     * 添加任务可以传参数
     *
     * @param clazz
     * @param jobName
     * @param groupName
     * @param cronExp
     * @param param
     */
    void addJob(Class clazz, String jobName, String groupName, String cronExp, Map<String, Object> param);

    /**
     * 暂停任务
     *
     * @param name
     * @param groupName
     */
    void pauseJob(String name, String groupName);

    /**
     * 恢复任务
     *
     * @param name
     * @param groupName
     */
    void resumeJob(String name, String groupName);

    /**
     * 更新任务
     *
     * @param name
     * @param groupName
     * @param cronExp
     * @param param
     */
    void updateJob(String name, String groupName, String cronExp, Map<String, Object> param);

    /**
     * 删除任务
     *
     * @param name
     * @param groupName
     */
    void deleteJob(String name, String groupName);

    /**
     * 启动所有任务
     */
    void startAllJobs();

    /**
     * 关闭所有任务
     */
    void shutdownAllJobs();

    /**
     * 	添加定时任务
     * @param cs
     * @return
     */
	int addJob(CustomScheduler cs) throws Exception;

	/**
	 * 	查看所有定时任务
	 * @return
	 */
	List<CustomSchedulerVO> findAllQuartzs();
}
