package com.jeremyeliassen.anexcellenthost.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.security.CurrentUser;
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
			return "home";
		}	
		return "account";
	}	
	
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user,
			BindingResult errors) { 
		if( errors.hasErrors()) {
			return "create_account";
		}
		if(user != userService.findByUsername(user.getUsername())) {		
		userService.createUser(user);
		
		return "enter";
		} else {
			System.out.println("User already exists");
			//I would have an alert here, but I couldn't remember how to do that.
			//For now you kinda have to key in to it refreshing and not taking or 
			//read the console. Would be fixed in a future build.
			return "create_account";
		}
	}	
	
	@PostMapping("/removeUser")
	public String removeUser(@Valid @ModelAttribute("currentUser") User user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "account";
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
		userService.removeUser(currentUser.getUser());
		return "logout";
	}
	
	//There wasn't enough time for me to complete this method for changing username.
//	@PostMapping("/updateUser")
//	public String updateUser(@ModelAttribute("user") User user) {
//		System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getId());
//		User user = userService.findByUsername(username);
//		user.setUsername(username);/////////////////////////////////////////////////////////////////)		
//		return "account";
//	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam String password, Model model) {
		String newpass = password;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
		currentUser.getUser().setPassword(newpass);
		userService.createUser(currentUser.getUser());
		return "account";
	}	
}
