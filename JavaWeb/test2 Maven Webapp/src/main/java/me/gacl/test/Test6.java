package me.gacl.test;

import java.util.HashMap;
import java.util.Map;

import me.gacl.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test6 {

	@Test
	public void testGetUserCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "me.gacl.mapping.userMapper.getUserCount";
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", -1);
		sqlSession.selectOne(statement, parameterMap);
		int result = parameterMap.get("usercount");
		System.out.println(result);
		sqlSession.close();
	}
}
