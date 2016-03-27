package cn.javass.spring.chapter3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class MethodInjectTest {

	@Test
	public void testLookUp() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"chapter3/lookupMethodInject.xml");
		System.out.println("==========singleton sayHello===========");
		HelloApi helloApi1 = ctx.getBean("helloApi1", HelloApi.class);
		helloApi1.sayHello();
		HelloApi helloApi2 = ctx.getBean("helloApi1", HelloApi.class);
		helloApi2.sayHello();

		System.out.println("=======prototype sayHello======");
		HelloApi helloApi3 = ctx.getBean("helloApi2", HelloApi.class);
		helloApi3.sayHello();
		helloApi3 = ctx.getBean("helloApi2", HelloApi.class);
		helloApi3.sayHello();
	}
}
