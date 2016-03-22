package cn.javass.spring.chapter3.bean;

public class Singleton {
	
	private Singleton() {}
	
	private static class InstanceHolder {
		private final static Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return InstanceHolder.INSTANCE;
	}
	
	private int counter = 0;
}
