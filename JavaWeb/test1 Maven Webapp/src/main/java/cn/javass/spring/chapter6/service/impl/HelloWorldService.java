package cn.javass.spring.chapter6.service.impl;

import cn.javass.spring.chapter6.service.IHelloWorldService;

public class HelloWorldService implements IHelloWorldService {

	public void sayHello() {
		System.out.println("===================Hello World!");
	}

	public void sayBefore(String param) {
		System.out.println("==================say "+param);
	}

	public boolean sayAfterReturning() {
		System.out.println("=====================after returning");
		return true;
	}

	public void sayAfterThrowing() {
		System.out.println("============before throwing");
		throw new RuntimeException();
	}
	
	public void sayAfterFinally() {
		System.out.println("============before finally");
		throw new RuntimeException();
	}

	public void sayAround(String param) {
		System.out.println("=============around param:"+param);
	}

	public void sayAdvisorBefore(String param) {
		System.out.println("====================say "+param);
	}
	
}
