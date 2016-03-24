package cn.javass.spring.chapter12.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter3.HelloImpl3;
import cn.javass.spring.chapter3.HelloImpl4;
import cn.javass.spring.chapter3.HelloImpl5;
import cn.javass.spring.chapter3.bean.Printer;

@Configuration
public class ApplicationContextConfig {

	@Bean
	public String message() {
		return new String("hello3");
	}
	
	@Bean
	public HelloApi helloImpl3() {
		return new HelloImpl3(message(), 1);
	}
	
	@Bean
	public HelloApi helloImpl4() {
		HelloImpl4 helloImpl4 = new HelloImpl4();
		helloImpl4.setMessage(message());
		helloImpl4.setIndex(1);
		return helloImpl4;
	}
	
	@Bean
	@Scope(value="prototype")
	public Printer prototypePrinter() {
		return new Printer();
	}
	
	@Bean
	@Scope(value="singleton")
	public Printer singletonPrinter() {
		return new Printer();
	}
	
	@Bean
	@Scope("singleton")
	public HelloApi helloApi2() {
		HelloImpl5 helloImpl5 = new HelloImpl5() {
			
			@Override
			public Printer createPrototypePrinter() {
				return prototypePrinter();
			}
			
			@Override
			public Printer createSingletonPrinter() {
				return singletonPrinter();
			}
		};
		
		helloImpl5.setPrinter(singletonPrinter());
		return helloImpl5;
	}
}
