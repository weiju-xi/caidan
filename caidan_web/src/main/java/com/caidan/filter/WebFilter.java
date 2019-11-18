package com.caidan.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class WebFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 获取request上下文
		RequestContext requestContext = RequestContext.getCurrentContext();
		//	获取得到request域
		HttpServletRequest request = requestContext.getRequest();
		//	判断是否有头信息
		String authorization = request.getHeader("Authorization");
		//	头信息向下传递
		if(StringUtils.isNotBlank(authorization)) {
			requestContext.addZuulRequestHeader("Authorization", authorization);
		}
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
