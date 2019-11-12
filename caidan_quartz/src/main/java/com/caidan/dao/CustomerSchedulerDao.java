package com.caidan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caidan.pojo.model.CustomScheduler;

public interface CustomerSchedulerDao extends JpaRepository<CustomScheduler, Long> {

	List<CustomScheduler> findAll();
	
	CustomScheduler saveAndFlush(CustomScheduler cs);
}
