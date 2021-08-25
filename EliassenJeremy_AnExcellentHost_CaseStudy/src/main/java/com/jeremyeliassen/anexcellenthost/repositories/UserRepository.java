package com.jeremyeliassen.anexcellenthost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremyeliassen.anexcellenthost.models.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findById(int id);

	User findByUsername(String username);
}
