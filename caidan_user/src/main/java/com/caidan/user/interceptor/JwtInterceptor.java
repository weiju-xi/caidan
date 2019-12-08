package com.caidan.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.caidan.util.JwtUtil;

import io.jsonwebtoken.Claims;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtUtil jwtUtil;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String authorization = request.getHeader("Authorization");
		if(authorization != null && authorization.startsWith("Bearer ")) {
			final String token = authorization.substring(7);
			Claims claims = jwtUtil.parseJWT(token);
			if(claims != null && claims.get("roles") != null) {
				String roles = String.valueOf(claims.get("roles"));
				if(roles != null && "amdin".equals(roles)) {
					request.setAttribute("claims_admin", roles);
				}else {
					request.setAttribute("claims_user", roles);
				}
			}
		}
		
		return true;
	}
}
