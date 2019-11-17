package com.caidan.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.caidan.result.TableDataInfo;

@FeignClient("caidan-quartz")
public interface QuartzClient {

	@GetMapping("/quartzs/list")
	public TableDataInfo<?> list();
}
