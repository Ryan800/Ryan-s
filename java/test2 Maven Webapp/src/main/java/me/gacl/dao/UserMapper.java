package me.gacl.dao;

import me.gacl.domain.user.User;


public interface UserMapper {
	int deleteByPrimaryKey(String userId);
	int insert(User record);
	User selectByPrimaryKey(String userId);
	int updateByPrimaryKeySelective(User record);
	int updateByPrimaryKey(User record);
}
