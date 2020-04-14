package com.caidan.test;
/**
 *	拷贝小括号， 写死右箭头， 落地大括号 
 *
 */
public class LambdaExpressTest {
	public static void main(String[] args) {
//		Foo foo = () -> {System.out.println("say Hello");};
		Foo foo = (x,y) -> {
			System.out.println("进入LambdaExpress 方法");
			return x+y;
		};
		System.out.println(foo.add(8, 9));;
	}
}
@FunctionalInterface
interface Foo{
//	public void sayHello();
	public int add(int x, int y);
	
	default int div(int x, int y) {
		return x/y;
	}
	
	static int mv(int x, int y) {
		return x*y;
	}
}
