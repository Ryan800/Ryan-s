package cn.javass.spring.chapter6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter6.service.IHelloWorldService;
import cn.javass.spring.chapter6.service.IIntroductionService;

public class AopTest {

	@Test
	public void testHelloworld() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/helloworld.xml");
//		IHelloWorldService helloWorldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
//		helloWorldService.sayHello();
		
		IHelloWorldService helloWorldService2 = ctx.getBean("helloWorldService", IHelloWorldService.class);
		helloWorldService2.sayHello();
		helloWorldService2.sayBefore("你好");
		System.out.println("===============================");
		helloWorldService2.sayAfterReturning();
		System.out.println("===============================");
//		helloWorldService2.sayAfterThrowing();
//		System.out.println("===============================");
//		helloWorldService2.sayAfterFinally();
//		System.out.println("===============================");
		helloWorldService2.sayAround("haha");
		System.out.println("===============================");
	}
	
	@Test
	public void testSchemaIntroduction() {
		System.out.println("==================================================");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/helloworld.xml");
		IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
		introductionService.induct();
		System.out.println("==================================================");
	}
	
	@Test
	public void testSchemaAdvisor() {
		System.out.println("==============================================================");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/advice.xml");
		IHelloWorldService helloWorldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
		helloWorldService.sayAdvisorBefore("hahahaha");
		System.out.println("==============================================================");
	}
}
