package org.perscholas.services;

import org.perscholas.models.User;

public interface UserService {

	User createUser(User user);
	User findUserById(int id);
//	User findUserByEmail(String email);
	void removeUser(User user);
	Iterable<User> getAll();
	User save(User user);
	User findById(int id);
}
