package com.jeremyeliassen.anexcellenthost.servicesimpl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.repositories.UserRepository;
import com.jeremyeliassen.anexcellenthost.services.UserService;

@Service
public class UserServiceImplement implements UserService {

	private UserRepository userRepository;
	private PasswordEncoder pswdEncoder;
	
	@Autowired
	public UserServiceImplement(UserRepository userRepository, PasswordEncoder pswdEncoder) {
		this.userRepository = userRepository;
		this.pswdEncoder = pswdEncoder;
	}
	
	@Override
	public User createUser(User user) {
		//Put in a check to see if the user exists here
		user.setPassword(pswdEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}


	@Override
	public User findById(Integer id) {
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public void removeUser(User user) {
		userRepository.delete(user);
	}
	
	@Override
	public Iterable<User> getAll() {
		return (Iterable<User>) userRepository.findAll();
	}



}
