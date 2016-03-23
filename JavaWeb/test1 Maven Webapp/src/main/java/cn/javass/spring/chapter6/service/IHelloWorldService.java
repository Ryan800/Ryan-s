package cn.javass.spring.chapter6.service;

public interface IHelloWorldService {
	void sayHello();
	void sayBefore(String param);
	public boolean sayAfterReturning();
	void sayAfterThrowing();
	void sayAfterFinally();
	void sayAround(String param);
	void sayAdvisorBefore(String param);
}
