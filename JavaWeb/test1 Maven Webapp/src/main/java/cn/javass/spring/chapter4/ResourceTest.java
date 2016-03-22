package cn.javass.spring.chapter4;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import cn.javass.spring.chapter4.bean.ResourceBean3;

public class ResourceTest {

	@Test
	public void testResourceLoad() {
//		ResourceLoader loader = new DefaultResourceLoader();
		ResourceLoader loader2 = new ClassPathXmlApplicationContext();
		Resource resource = loader2.getResource("classpath:properties/test.properties");
		try {
			InputStream inputStream = resource.getInputStream();
			Properties properties = new Properties();
			properties.load(inputStream);
			String value = properties.getProperty("aaa");
			System.out.println(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:chapter4/resourceInject.xml");
		ResourceBean3 resourceBean1 = ctx.getBean("resourceBean1", ResourceBean3.class);
		ResourceBean3 resourceBean2 = ctx.getBean("resourceBean2", ResourceBean3.class);
		System.out.println("test");
	    Assert.assertTrue(resourceBean1.getResource() instanceof ClassPathResource);
	    Assert.assertTrue(resourceBean2.getResource() instanceof ClassPathResource);
	}
}

