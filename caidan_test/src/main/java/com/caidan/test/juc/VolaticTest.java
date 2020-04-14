package com.caidan.test.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	请谈谈对volatile的理解
 *	1、volatile是java虚拟机提供的轻量级的同步机制
 *		保证可见性
 *		不保证原子性
 *		禁止指令重排
 *			处理器在进行重排序时必须要考虑指令之间的数据依赖性
 *
 *	JMM(java Memory Model) 是一种抽象的概念，并不真实存在，它描述的是一组规则或规范
 *	通过这组规范定义了程序中各个变量（包括实例字段，静态字段和构成数组对象的元素）的访问方式。
 *	1、可见性
 *	2、原子性
 *		不可分割，完整性，即某个线程正在做某个具体的业务时，中间不能被加塞或者分割，要整体完成
 *	3、有序性
 *
 *  JMM关于同步的规定：
 *  1、线程解锁前，必须把共享变量的值刷新会主内存
 *  2、线程加锁前，必须读取主内存的最新值到自己的工作内存
 *  3、加锁解锁是同一把锁
 */
public class VolaticTest {

	public static void main(String[] args) {
		
		MyData myData = new MyData();
		
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					myData.increment();
				}
			}, String.valueOf(i)).start();
		}
		
		while(Thread.activeCount() > 2) {
			Thread.yield();
		}
		
		System.out.println(Thread.currentThread().getName() +" finally number value =" + myData.number);
	}

	//	volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
	private static void seeOkByVolatile() {
		MyData myData = new MyData();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() +" start ");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			myData.add();
			myData.addAtomic();
			System.out.println(Thread.currentThread().getName() +" end ");
		}, "A").start();
		
		while(myData.number == 0) {
			
		}
		
		System.out.println(Thread.currentThread().getName() +"main get number value : "+ myData.number);
	}
}

class MyData{
	volatile int number = 0;
	AtomicInteger atomicInteger = new AtomicInteger();
	
	public void add() {
		this.number = 60;
	}
	
	public synchronized void increment() {
		number++;
	}
	
	public void addAtomic() {
		atomicInteger.getAndIncrement();
	}
}
