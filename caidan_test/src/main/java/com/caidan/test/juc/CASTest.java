package com.caidan.test.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 	1、CAS （compare and swap） 比较并交换，它是一条CPU并发原语
 * 		底层使用Unsafe,是CAS的核心类，由于java方法无法直接访问底层系统，需要通过本地方法来访问，Unsafe相当于一个后门，
 * 		基于该类可以直接操作特定的内存数据，Unsafe类存在于sum.misc包中，其内部方法可以像C的指针
 * 		一样来操作内存，Unsafe类中所有的方法都是navite修饰的，方法都是直接调用操作系统底层资源执行相应的任务
 * 		
 * 		它的功能是判断内存摸个位置的值是否为预期值，如果是则更改为新值，这个过程是原子的
 * 		
 * 	2、CAS 缺点
 * 		循环时间长开销大
 * 		只能保证一个共享变量原子操作
 * 		会引发出ABA的问题	
 * 			
 *
 */
public class CASTest {
	public static void main(String[] args) {
		AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,1);
		
		new Thread(() -> {
			int stamp = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"--第一次版本号为"+stamp);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			atomicStampedReference.compareAndSet(100, 101, stamp,stamp+1);
			System.out.println(Thread.currentThread().getName()+"--第二次版本号为"+atomicStampedReference.getStamp());
			atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"--第三次版本号为"+atomicStampedReference.getStamp());
		}, "A").start();
		
		new Thread(() -> {
			int stamp = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"--第一次版本号为"+stamp);
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean b = atomicStampedReference.compareAndSet(100, 2020, stamp,stamp+1);
			System.out.println(Thread.currentThread().getName() + "--执行结果为" + b + "，当前版本号为--"
					+ atomicStampedReference.getStamp() + ",最终结果为" + atomicStampedReference.getReference());
		}, "B").start();
		
	}

	private static void AtomicReferenceTest() {
		AtomicReference<String> atomicReference = new AtomicReference<String>();
		atomicReference.set("111");
		
		System.out.println(Thread.currentThread().getName()+"cas交换结果："+atomicReference.compareAndSet("111", "222") +"值信息"+ atomicReference.get());
	}

	private static void atomicIntegerTest() {
		AtomicInteger atomicInteger = new AtomicInteger(5);
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+"---------"+atomicInteger.compareAndSet(5, 2019));
		}, "A").start();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+"---------"+atomicInteger.compareAndSet(5, 1024));
		}, "B").start();
	}
}
