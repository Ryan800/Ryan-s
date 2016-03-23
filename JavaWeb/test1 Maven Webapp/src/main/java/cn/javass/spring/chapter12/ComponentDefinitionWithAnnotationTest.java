package cn.javass.spring.chapter12;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter12.dao.hibernate.TestHibernateDaoImpl;

public class ComponentDefinitionWithAnnotationTest {

	private static String configLocation = "classpath:chapter12/componentDefinitionWithAnnotation.xml";
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			configLocation);
	@Test
	public void testComponent() {
		TestCompoment testCompoment = ctx.getBean("component", TestCompoment.class);
		if (testCompoment.getCtx()!=null) {
			System.out.println("not null");
		} else {
			System.out.println("null");
		}
//		Assert.assertNotNull(testCompoment.getCtx());
	}
	
	@Test
	public void testDao() {
		TestHibernateDaoImpl dao = ctx.getBean("testHibernateDao", TestHibernateDaoImpl.class);
		Assert.assertNotNull(dao);
	}
}
