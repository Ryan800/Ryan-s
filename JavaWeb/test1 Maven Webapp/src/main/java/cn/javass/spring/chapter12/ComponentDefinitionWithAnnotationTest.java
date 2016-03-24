package cn.javass.spring.chapter12;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.javass.spring.chapter12.action.TestAction;
import cn.javass.spring.chapter12.cache.TestCache;
import cn.javass.spring.chapter12.dao.hibernate.TestHibernateDaoImpl;
import cn.javass.spring.chapter12.service.impl.TestServiceImpl;

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
	
	@Test
	public void testService() {
		TestServiceImpl service = ctx.getBean("testService", TestServiceImpl.class);
		Assert.assertNotNull(service.getDao());
	}
	
	@Test
	public void testWeb() {
		TestAction action = ctx.getBean("testAction", TestAction.class);
		Assert.assertNotNull(action);
	}
	
	@Test
	public void testCache() {
		TestCache cache = ctx.getBean("cache", TestCache.class);
		Assert.assertNotNull(cache);
	}
}
