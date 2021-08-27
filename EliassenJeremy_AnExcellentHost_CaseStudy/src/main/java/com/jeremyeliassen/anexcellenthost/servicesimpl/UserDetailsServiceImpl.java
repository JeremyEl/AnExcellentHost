package com.jeremyeliassen.anexcellenthost.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.repositories.UserRepository;
import com.jeremyeliassen.anexcellenthost.security.CurrentUser;

//This is a class involved with Spring. I did not write this, change it, or do anything with it.
//But if I delete it, everything breaks, so here it stays.

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		return new CurrentUser(user);
	}

}
