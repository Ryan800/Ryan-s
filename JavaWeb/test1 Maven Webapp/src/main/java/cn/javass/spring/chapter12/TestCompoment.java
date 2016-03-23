package cn.javass.spring.chapter12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("component")
public class TestCompoment {
	@Autowired
	private ApplicationContext ctx;

	public ApplicationContext getCtx() {
		return ctx;
	}
	
}
