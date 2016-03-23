package cn.javass.spring.chapter12;

import org.springframework.beans.factory.annotation.Autowired;


public class TestBean12 {
	private String message;
	@Autowired
	private TestBean122 testBean122;

	public TestBean122 getTestBean122() {
		return testBean122;
	}

	public void setTestBean122(TestBean122 testBean122) {
		this.testBean122 = testBean122;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
