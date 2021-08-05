package org.perscholas.repositories;

import org.perscholas.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);
}
