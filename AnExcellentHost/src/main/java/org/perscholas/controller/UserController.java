package org.perscholas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.perscholas.models.User;
import org.perscholas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//TODO Do I even keep this one? It's like a one-use thing, right?
//	@ModelAttribute("userkey")
//	public User setUpUserForm() {
//		return userService.findUserById(1);
//	}

	
	
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user,
			BindingResult errors) {
		System.out.println("has errors? " + errors.hasErrors());
		if( errors.hasErrors()) {
			return"Login";
		}
		
		System.out.println(user.toString());
		User savedUser = userService.createUser(user);
		System.out.println(savedUser.toString());
		return "redirect:/";
		
	}
	
	@PostMapping("/removeUser{id}")
	public String removeUser(@PathVariable int id) {
		User user = userService.findUserById(id);
		if (user != null) {
			userService.removeUser(user);
		}
		return "redirect:/";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.setAllowedFields(new String[] {"name", "email"});
//		binder.setDisallowedFields("password");
	}
	
}
