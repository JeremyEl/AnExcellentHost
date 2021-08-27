package com.jeremyeliassen.anexcellenthost;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.services.UserService;

@SpringBootApplication
public class EliassenJeremyAnExcellentHostCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EliassenJeremyAnExcellentHostCaseStudyApplication.class, args);
	}

	//IMPORTANT NOTE
	//This makes some example users to right away log in with.
	//Application.properties is currently set to UPDATE
	//which means every time the server is restarted, these same 4 users are added
	//which might make problems with duplicates elsewhere.
	
//	@Bean
//	public CommandLineRunner insertEmployeeRecords(UserService userService) {
//		return args -> {
//			// Save two standard users (ROLE_USER)
//			userService.createUser(new User("John", "john1234"));
//			userService.createUser(new User("Jane", "jane1234"));
//			
//			// Save two admin users (ROLE_ADMIN)
//			User user = null;
//			user = new User("aaa", "aaa");
//			user.setUserRole("ROLE_ADMIN");
//			userService.createUser(user);
//			user = new User("ss", "ss");
//			user.setUserRole("ROLE_ADMIN");
//			userService.createUser(user);		};
//	}
}
