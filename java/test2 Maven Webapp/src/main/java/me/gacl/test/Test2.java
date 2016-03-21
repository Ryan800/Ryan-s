package me.gacl.test;

import me.gacl.domain.Order;
import me.gacl.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test2 {

	@Test
	public void testGetOrderById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "me.gacl.mapping.orderMapper.getOrderById";
		Order order = sqlSession.selectOne(statement, 1);
		sqlSession.close();
		System.out.println(order);
	}
	
	@Test
	public void testGetOrderById2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		String statement = "me.gacl.mapping.orderMapper.selectOrder";
		Order order = sqlSession.selectOne(statement, 1);
		sqlSession.close();
		System.out.println(order);
	}
	
	@Test
	public void testGetOrderById3() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "me.gacl.mapping.orderMapper.selectOrderResultMap";
		
		Order order = sqlSession.selectOne(statement, 1);
		sqlSession.close();
		System.out.println(order);
	}
}
