package me.gacl.test;

import java.io.InputStream;

import me.gacl.domain.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test1 {

	public static void main(String[] args) {
		String resourse = "conf.xml";
		InputStream is = Test1.class.getClassLoader().getResourceAsStream(resourse);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		String statement = "me.gacl.mapping.userMapper.getUser";
		User user = session.selectOne(statement, 1);
		System.out.println(user);
	}

}
