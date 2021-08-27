package com.jeremyeliassen.anexcellenthost.services;

import com.jeremyeliassen.anexcellenthost.models.User;

public interface UserService {
	User createUser(User user);
	User findById(Integer id);
	void removeUser(User user);
	Iterable<User> getAll();
	User findByUsername(String username);
}
