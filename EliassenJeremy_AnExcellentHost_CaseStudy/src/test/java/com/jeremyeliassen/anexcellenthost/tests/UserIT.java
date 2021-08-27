package com.jeremyeliassen.anexcellenthost.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.services.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserIT {
	private UserService userService;
	
	@Autowired
	public UserIT(UserService userService) {
		this.userService = userService;
	}
	
	@Test 
	void testFindByUsername() {
		
		String saveName = "John";
		User foundUser = userService.findByUsername("John");
		assertEquals(saveName, foundUser.getUsername());
	}
	
	@Test
	void testCreateUser() {
		User testUser = new User("username1", "password1");
		testUser = userService.createUser(testUser);
		String testCompare = "username1";
		String testUserReceive = userService.findByUsername(testUser.getUsername()).getUsername();
		assertEquals(testCompare, testUserReceive);
		
	}
	
	
}
