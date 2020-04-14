package com.caidan.test;
/**
 * 	1、高内聚低耦合的前提下，线程操作资源类
 * 	2、判断 | 干活 | 通知
 * 	3、多线程交互中必须要防止多线程的虚假唤醒（判断智能用while，不能用if）
 * @author gouzi
 *
 */
public class ThreadWaitNotifyTest {

	public static void main(String[] args) {
		AirConditioner airconditioner = new AirConditioner();
		
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airconditioner.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "A").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airconditioner.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "B").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airconditioner.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "C").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					airconditioner.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "D").start();
	}
}

class AirConditioner{
	private int number = 0;
	
	public synchronized void increment() throws InterruptedException {
		if(number != 0) {
			this.wait();
		}
		number++;
		
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		
		this.notifyAll();
	}
	
	public synchronized void decrement() throws InterruptedException {
		if(number == 0) {
			this.wait();
		}
		
		number--;
		
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		
		this.notifyAll();
	}
}