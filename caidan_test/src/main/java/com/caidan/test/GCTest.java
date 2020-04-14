package com.caidan.test;

import java.util.Random;

/**
 *	垃圾回收的四种算法
 *	1、引用计数
 *	2、复制拷贝
 *	3、标记清除
 *	4、标记整理
 *	垃圾回收器
 *	1、serial 串行垃圾回收器
 *	2、parallel 并行垃圾回收器
 *	3、CMS 并发垃圾回收器 ConcMarkSweep
 *	4、 G1
 *	java8 默认的垃圾回收器  -XX:+UseParallelGC 
 *	
 *	查看jvm默认垃圾回收器指令  java -XX:+PrintCommandLineFlags -versioin
 *	
 *	默认垃圾回收器 一共有7个  其中有一种UseSerialOldGC 已弃用
 *	UseSerialGC, UseParallelGC, UseConcMarkSweepGC
 *	UseParNewGC, UseParallelOldGC, UseG1GC  
 *
 *	垃圾回收器测试参数
 *	1、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 *	2、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC (Deprecated)
 *	3、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC
 *	4、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
 *	5、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 *
 *	CMS并发垃圾回收算法的四个步骤
 *	1、Initial Mark 标记GC Root可以直达的对象，耗时短
 *	2、Concurrent Mark 从第一步标记的对象出发，并发的标记可达对象
 *	3、Remark 重新进行标记，修正Concurrent Mark期间由于用户程序运行而导致对象关系间的变化及新创建的对象，耗时短
 *	4、Concurrent Sweep	并行的进行无用对象的回收
 *
 * @author gouzi
 *
 */
public class GCTest {

	public static void main(String[] args) {
		 serialTest();
	}
	
	public static void serialTest() {
		try {
			String str = "caidan";
			while(true) {
				str += str + new Random().nextInt(7777777) + new Random().nextInt(8888888);
				str.intern();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
