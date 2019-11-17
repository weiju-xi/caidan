package com.caidan.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.caidan.client.impl.QuartzClientImpl;
import com.caidan.result.TableDataInfo;

@FeignClient(value="caidan-quartz", fallback = QuartzClientImpl.class)
public interface QuartzClient {

	@GetMapping("/quartzs/list")
	public TableDataInfo<?> list();
}
