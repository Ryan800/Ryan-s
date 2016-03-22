package cn.javass.spring.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;

public class DependencyInjectTest {

	@Test
	public void testBeanInject() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"chapter3/beanInject.xml");
		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
		bean1.sayHello();

		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

	@Test
	public void testLocalAndparentBeanInject() {
		ApplicationContext parentBeanContext = new ClassPathXmlApplicationContext("chapter3/parentBeanInject.xml");
		ApplicationContext beanContext = new ClassPathXmlApplicationContext(new String[] {"chapter3/localBeanInject.xml"}, parentBeanContext);
		
		HelloApi bean1 = beanContext.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		
		HelloApi bean2 = beanContext.getBean("bean2", HelloApi.class);
		bean2.sayHello();

	}
	@Test
	public void testInnerBeanInject() {
		ApplicationContext context = new ClassPathXmlApplicationContext("chapter3/innerBeanInject.xml");
		HelloApi bean = context.getBean("bean", HelloApi.class);
		bean.sayHello();
	}
}
