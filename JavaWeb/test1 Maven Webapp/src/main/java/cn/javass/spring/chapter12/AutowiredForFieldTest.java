package cn.javass.spring.chapter12;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredForFieldTest {

	@Test
	public void testAutowiredForField() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter12/dependecyInjectWithAnnotation.xml");
		TestBean12 testBean12 = ctx.getBean("testBean12", TestBean12.class);
		System.out.println(testBean12.getMessage());
	}
}
