package me.gacl.test;

import java.io.File;


public class Test {

	@org.junit.Test
	public void test() {
		String path = "C:\\Users\\wangbw\\Desktop\\session.log";
		File file = new File(path);
		boolean isFile = file.isFile();
		if (file.exists()) {
			System.out.println("ok");
		} else {
			System.out.println();
		}
	}
}
