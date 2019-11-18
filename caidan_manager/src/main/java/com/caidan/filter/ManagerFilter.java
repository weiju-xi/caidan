package com.caidan.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caidan.util.JwtUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import io.jsonwebtoken.Claims;

@Component
public class ManagerFilter extends ZuulFilter{
	
	@Autowired
	private JwtUtil jwtUtil;

	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 	过滤执行的操作，发挥任何值都代表放行
	 * 	setsendzuulResponse(false) 表示不再继续执行
	 */
	@Override
	public Object run() throws ZuulException {
		System.out.println("ManagerFilter  已执行");
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String header = request.getHeader("Authorization");
		if(StringUtils.isNotBlank("Authorization")) {
			if(header.startsWith("Bearer")) {
				String token = header.substring(7);
				//	不想写了 ,等到写 jwt的时候再返工
//				try {
//					Claims parseJWT = jwtUtil.parseJWT(token);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//					requestContext.setSendZuulResponse(false); //终止运行
//				}
				return null;
			}
			
		}
		return null;
	}

	/**
	 * 	过滤器类型： pre post
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 	多个过滤器的执行顺序，数字越小越先执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
