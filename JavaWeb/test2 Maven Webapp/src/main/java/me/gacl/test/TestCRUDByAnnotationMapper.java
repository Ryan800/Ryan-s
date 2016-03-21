package me.gacl.test;

import me.gacl.domain.User;
import me.gacl.mapping.UserMapperI;
import me.gacl.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCRUDByAnnotationMapper {
	
	@Test
	public void testAdd() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setName("用户xdp");
		user.setAge(20);
		int add = mapper.add(user);
		sqlSession.clearCache();
		System.out.println(add);
	}
}
