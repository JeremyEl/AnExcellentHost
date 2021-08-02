package org.perscholas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.perscholas.models.User;
import org.perscholas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//TODO Do I even keep this one? It's like a one-use thing, right?
	@ModelAttribute("userkey")
	public User setUpUserForm() {
		return userService.findUserById(1);
	}

	//TODO fix this one?
	@GetMapping("/")
	public String showIndexPage(Model model, HttpSession session) {
		model.addAttribute("user", new User());
//		session.setAttribute("userkey", userService.findUserById(!!!!!!!!!!!!!!!));
		return "index";
	}
	
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user,
			BindingResult errors) {
		System.out.println("has errors? " + errors.hasErrors());
		if( errors.hasErrors()) {
			return"index";
		}
		
		System.out.println(user.toString());
		User savedUser = userService.createUser(user);
		System.out.println(savedUser.toString());
		return "redirect:/";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.setAllowedFields(new String[] {"name", "email"});
//		binder.setDisallowedFields("password");
	}
	
}
