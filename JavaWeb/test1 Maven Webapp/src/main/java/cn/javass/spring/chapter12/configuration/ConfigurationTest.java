package cn.javass.spring.chapter12.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter3.HelloImpl3;

public class ConfigurationTest {

	@Autowired
	@Qualifier(value="helloImpl2")
	HelloApi helloImpl2;
	
	@Test
	public void testAutowired() {
		helloImpl2.sayHello();
	}
	
	@Test
	public void testHelloworld() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		Assert.assertEquals("hello", ctx.getBean("message"));
		ctx.close();
	}
	
	@Test
	public void testDependencyInject() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		ctx.getBean("helloImpl3", HelloApi.class).sayHello();
		ctx.getBean("helloImpl4", HelloApi.class).sayHello();
		ctx.close();
	}
	
	@Test
	public void testLookupMethodInject() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		System.out.println("=================prototype sayHello==============");
		HelloApi helloApi = ctx.getBean("helloApi2", HelloApi.class);
		helloApi.sayHello();
		helloApi = ctx.getBean("helloApi2", HelloApi.class);
		helloApi.sayHello();
	}
}
