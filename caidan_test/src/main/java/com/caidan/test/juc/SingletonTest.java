package com.caidan.test.juc;

public class SingletonTest {

	private static volatile SingletonTest instance = null;
	
	private SingletonTest() {
		System.out.println(Thread.currentThread().getName()+"SingletonTest无参构造方法");
	}
	//	DCL （Doouble Check Lock 双端检索机制）
	public static SingletonTest getInstance(){
		if(instance == null) {
			synchronized (SingletonTest.class) {
				if(instance == null) {
					instance = new SingletonTest();
				}
			}
		}
		
		return instance;
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				SingletonTest.getInstance();
			}, String.valueOf(i)).start();
		}
	}
}
