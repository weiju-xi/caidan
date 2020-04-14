package com.caidan.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *	1、在高内聚低耦合的前提下 线程	操作	资源类
 *	start 之后进入就绪状态，等待操作系统底层调动通知
 *	多线程状态 New Runable Blocked Waiting Time_Waiting Terminated
 *	wait 和  sleep 都会暂停当前线程， wait会释放锁，sleep还会持有锁
 *	
 *
 */
public class ThreadTest {

	public static void main(String[] args) {
		salcTicket();
	}

	private static void salcTicket() {
		Ticket ticket = new Ticket();

//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 40; i++) {
//					ticket.saleTicket();
//				}
//			}
//		}, "AAA").start();
//		
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 40; i++) {
//					ticket.saleTicket();
//				}
//			}
//		}, "BBB").start();
//
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < 40; i++) {
//					ticket.saleTicket();
//				}
//			}
//		}, "CCC").start();
		
		new Thread(() -> {for (int i = 0; i < 40; i++) ticket.saleTicket();},"A") .start();
		new Thread(() -> {for (int i = 0; i < 40; i++) ticket.saleTicket();},"B") .start();
		new Thread(() -> {for (int i = 0; i < 40; i++) ticket.saleTicket();},"C") .start();
	}
}
/**
 *	资源类 	
 */
class Ticket{
	private Lock lock = new ReentrantLock();
	private int number = 30;
	
	public void saleTicket() {
		lock.lock();
		try {
			if(number > 0) {
				System.out.println(Thread.currentThread().getName()+"\t 卖出第"+(number--)+"张票，还剩"+number);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}