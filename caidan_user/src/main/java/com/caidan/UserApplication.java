package com.caidan;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.caidan.util.IdWorker;
import com.caidan.util.JwtUtil;

@MapperScan("com.caidan.user.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class UserApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(UserApplication.class, args);
    }
    
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public JwtUtil jwtUtil() {
    	return new JwtUtil();
    }

}
