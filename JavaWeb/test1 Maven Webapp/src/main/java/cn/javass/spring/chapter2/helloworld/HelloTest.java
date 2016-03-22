package cn.javass.spring.chapter2.helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	@Test
	public void testHelloWorld() {
		ApplicationContext context = new ClassPathXmlApplicationContext("chapter2/helloworld.xml");
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		helloApi.sayHello();
	}
}
