package cn.javass.spring.chapter3;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class HelloImpl3 implements HelloApi {

	private String messsage;
	private int index;
	
	public HelloImpl3(String message, int index) {
		this.messsage = message;
		this.index = index;
	}
	
	public void sayHello() {
		System.out.println(index+":"+messsage);
	}

}
