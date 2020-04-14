package com.caidan.test;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 *	java8以后老年代改为元空间，由使用堆内存改为直接使用物理内存
 *	元空间中存放以下信息
 *	1、虚拟机加载的类型
 *	2、常量池
 *	3、静态变量
 *	4、即使编译后的代码
 *
 *	设置VM参数
 *	-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * 
 */
public class MetaspaceErrorTest {

	static class OOMTest{}
	public static void main(String[] args) {
		int i = 0;
		try {
			while(true) {
				i++;
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMTest.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					
					@Override
					public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
						return arg3.invokeSuper(arg0, args);
					}
				});
				enhancer.create();
			}
		} catch (Throwable e) {
			System.out.println("*******************方法执行次数i="+i);
			e.printStackTrace();
		}
	}
}
