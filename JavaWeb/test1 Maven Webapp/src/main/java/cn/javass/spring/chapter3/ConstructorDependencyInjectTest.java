package cn.javass.spring.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class ConstructorDependencyInjectTest {
	@Test
	public void testConstructorDependencyInjectTest() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("chapter3/constructorDependencyInject.xml");
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		
		BeanFactory beanFactory2 = new ClassPathXmlApplicationContext("chapter3/setterDependencyInject.xml");
		HelloApi bySetter = beanFactory2.getBean("bean", HelloApi.class);
		bySetter.sayHello();
	}
}
