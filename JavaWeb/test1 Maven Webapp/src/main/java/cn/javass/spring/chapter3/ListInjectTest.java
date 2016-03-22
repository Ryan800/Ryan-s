package cn.javass.spring.chapter3;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter3.bean.ListTestBean;

public class ListInjectTest {

	@Test
	public void testListInject() {
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("chapter3/listInject.xml");
		ListTestBean listTestBean = beanFactory.getBean("listBean", ListTestBean.class);
		System.out.println(listTestBean.getValues().size());
		Assert.assertEquals(3, listTestBean.getValues().size());
	}
	
}
