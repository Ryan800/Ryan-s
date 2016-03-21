package me.gacl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gacl.dao.UserMapper;
import me.gacl.domain.user.User;
import me.gacl.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void addUser(User user) {
		userMapper.insert(user);
	}

	public User getUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

}
