package com.test;

public class TestClass {

	static {
		System.out.println("static TestClass");
	}
	
	private TestClass(String str) {
		System.out.println(str);
	}
	
	private static TestClass instance = new TestClass("haha");
	
	public static String TC = "TestClasss]";
	
	public static TestClass getInstance() {
		return instance;
	}
}
