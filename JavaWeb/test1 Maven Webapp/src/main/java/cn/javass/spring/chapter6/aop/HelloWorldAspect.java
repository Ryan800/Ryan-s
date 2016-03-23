package cn.javass.spring.chapter6.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloWorldAspect {
	//前置通知
	public void beforeAdvice(String param) {
		System.out.println("==================before advise "+param);
	}
	
	//后置通知
	public void afterFinallyAdvice() {
		System.out.println("==================after finally advise");
	}
	
	public void afterReturningAdvice(Object retVal) {
		System.out.println("======================after returning advice retVal: " + retVal);
	}
	
	public void afterThrowingAdvice(Exception exception) {
		System.out.println("============after throwing advice exception: "+exception);
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("==================around before advice");
		Object retVal = pjp.proceed(new Object[]{"replace"});
		System.out.println("====================around after advice");
		return retVal;
	}
	
}
