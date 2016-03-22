package cn.javass.spring.chapter3;

import cn.javass.spring.chapter2.helloworld.HelloApi;
import cn.javass.spring.chapter3.bean.Printer;

public abstract class HelloImpl5 implements HelloApi {

	private Printer printer;
	
	public void sayHello() {
		printer.print("setter");
		createPrototypePrinter().print("prototype");
	}
	
	public abstract Printer createPrototypePrinter();
	
	public Printer createSingletonPrinter() {
		System.out.println("�÷������ᱻִ�У��������ʹ���");
        return new Printer();
	}
	
	public void setPrinter(Printer printer) {
        this.printer = printer;
    }

}
