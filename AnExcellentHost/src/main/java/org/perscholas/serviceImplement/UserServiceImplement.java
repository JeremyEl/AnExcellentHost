package org.perscholas.serviceImplement;

import java.util.Optional;

import org.perscholas.models.User;
import org.perscholas.repositories.UserRepository;
import org.perscholas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}

	@Override
	public void removeUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public Iterable<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 

}
