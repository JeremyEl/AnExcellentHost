package com.jeremyeliassen.anexcellenthost.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.services.UserService;



@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}	
	
	@GetMapping("/account")
	public String displayAccount(@ModelAttribute("user") User user,
			BindingResult errors) {
		if( errors.hasErrors()) {
			return "homePage";
		}	
		return "account";
	}	
	
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user,
			BindingResult errors) { 
		if( errors.hasErrors()) {
			return "createAccount";
		}
		if(user == userService.findByUsername(user.getUsername())) {		
		User savedUser = userService.createUser(user);
		
		return "userGetIn";
		} else {
			System.out.println("User already exists");
			return "createAccount";
		}
	}
	
	
	@PostMapping("/removeUser{id}")
	public String removeUser(@PathVariable int id) {
		User user = userService.findById(id);
		// Change to find by name, then if === this user
		if (user != null) {
			userService.removeUser(user);
		}
		return "redirect:/homePage";
	}
	
	
//	@GetMapping("/account")
//	public String showAccountPage(Model model) {
////		User user = userService.findUserById(id);
//		return "account";
//	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user) {
		System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getId());
//		User user = userService.findByUsername(username);
//		user.setUsername(username);/////////////////////////////////////////////////////////////////)		
		return "account";
	}
	
//	@PostMapping("/changePassword")
//	public String changePassword(@ModelAttribute("userpass") User user,
//			BindingResult errors) {
//		if( errors.hasErrors()) {
//			//////////////////////////////////////////////////////////////////
//			return "account";
//		}
//		
//		user.setPassword(null);/////////////////////////////////////////////////////////////////)
//		//ALERT GOES HERE
//		
//		return "account";
//	}
	
	
	
}
