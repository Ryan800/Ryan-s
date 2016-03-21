package me.gacl.service;

import me.gacl.domain.user.User;


public interface UserService {
	void addUser(User user);
	User getUserById(String userId);
}
