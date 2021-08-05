package org.persholas.integrationTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.perscholas.config.WebAppConfig;
import org.perscholas.models.User;
import org.perscholas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserIT {
	private UserService userService;
	
	@Autowired
	public UserIT(UserService userService) {
		this.userService = userService;
	}
	
	@Test 
	void testFindById() {
		User newUser = new User();
		newUser.setName("TEST NAME");
		newUser.setPassword("TESTPASS");
		User saveUser = userService.save(newUser);
		User foundUser = userService.findById(saveUser.getId());
		assertEquals(saveUser, foundUser);
	}
	
	
	
}
