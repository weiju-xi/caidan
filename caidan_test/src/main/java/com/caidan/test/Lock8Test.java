package com.caidan.test;

import java.util.concurrent.TimeUnit;

/**
 *	1、标准访问，请问先打印邮件还是先打印短信   						先邮件后短信
 *	2、 邮件方法暂停4秒钟，请问先打印邮件还是先打印短信 				先邮件后短信
 *	3、 新增一个hello方法，请问先打印邮件还是先打印hello			先hello后邮件
 *	4、 两部手机，请问先打印邮件还是短信							先短信后邮件
 *	5、 两个静态同步方法，同一部手机，先打印邮件还是打印短信			先邮件后短信
 *	6、 两个静态同步方法，两部手机，先打印邮件还是打印短信				先邮件后短信
 *	7、一个普通方法，一个静态方法，一部手机，请问先打印邮件还是短信 		先短信后邮件
 *	8、一个普通方法，一个静态方法，两部手机，请问先打印邮件还是短信 		先短信后邮件
 *
 */
public class Lock8Test {

	public static void main(String[] args) throws InterruptedException {
		Phone p = new Phone();
		
		new Thread(() -> {
			p.sendEmail();
		}, "A").start();
		
		Thread.sleep(200);

		new Thread(() -> {
			p.sendSMS();
		}, "B").start();
	}
}

class Phone{
	public synchronized void sendSMS() {
		System.out.println(Thread.currentThread().getName()+"\t sendSMS");
	}
	
	public synchronized void sendEmail() {
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"\t sendEmail");
	}
	
	public void hello() {
		System.out.println(Thread.currentThread().getName()+"\t hello");
	}
}