package org.perscholas.seattle_security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jeremyeliassen.anexcellenthost.WebAppConfig;
import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.services.UserService;

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
		newUser.setUsername("TEST NAME");
		newUser.setPassword("TESTPASS");
		newUser.setId(19);
		newUser.setUserRole(null);
		User saveUser = userService.createUser(newUser);
		User foundUser = userService.findById(saveUser.getId());
		assertEquals(saveUser, foundUser);
	}
	
	
	
}
