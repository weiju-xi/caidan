package com.caidan.client.impl;


import org.springframework.stereotype.Component;

import com.caidan.client.QuartzClient;
import com.caidan.result.Constant;
import com.caidan.result.TableDataInfo;
@Component
public class QuartzClientImpl implements QuartzClient{

	@Override
	public TableDataInfo<?> list() {
		TableDataInfo<?> dataInfo = new TableDataInfo<Object>(null, 0);
		dataInfo.setCode(Constant.INTERNAL_SERVER_ERROR);
		return dataInfo;
	}

}
