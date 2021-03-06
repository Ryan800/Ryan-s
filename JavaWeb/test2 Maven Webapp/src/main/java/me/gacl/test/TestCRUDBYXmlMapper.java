package me.gacl.test;

import java.util.List;

import me.gacl.domain.User;
import me.gacl.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCRUDBYXmlMapper {

	@Test
	public void testAdd() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "me.gacl.mapping.userMapper.addUser";
		User user = new User();
		user.setName("用户孤傲苍狼");
		user.setAge(20);
		int retResult = sqlSession.insert(statement, user);
		sqlSession.close();
		System.out.println(retResult);
	}

	@Test
	public void testUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "me.gacl.mapping.userMapper.updateUser";// 映射sql的标识字符串
		User user = new User();
		user.setId(3);
		user.setName("孤傲苍狼");
		user.setAge(25);
		// 执行修改操作
		int retResult = sqlSession.update(statement, user);
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}

	@Test
	public void testDelete() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "me.gacl.mapping.userMapper.deleteUser";// 映射sql的标识字符串
		// 执行删除操作
		int retResult = sqlSession.delete(statement, 5);
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}

	@Test
	public void testGetAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "me.gacl.mapping.userMapper.getAllUsers";// 映射sql的标识字符串
		// 执行查询操作，将查询结果自动封装成List<User>返回
		List<User> lstUsers = sqlSession.selectList(statement);
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(lstUsers);
	}
}
