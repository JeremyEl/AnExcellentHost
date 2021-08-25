package com.jeremyeliassen.anexcellenthost.controllers;

import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeremyeliassen.anexcellenthost.models.Image;
import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.services.UserService;


@Controller
public class HomeController {
	
	private UserService userService;
	
	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		// Get current user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		// Print current user granted authorities
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println(authorities);
		if(!principal.equals("anonymousUser")) {
			model.addAttribute("currentUser", ((UserDetails)principal).getUsername());
		}	
		return "homePage";
	}
	
	@GetMapping("/homePage")
	public String showHomePage() {
		return "homePage";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "userGetIn";
	}
	
	@GetMapping("/userGetIn")
	public String showActualLoginPage() {
		return "userGetIn";
	}
	
	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		return "access_denied";
	}
	
	@GetMapping("/admin")
	public String showAdminPage() {
		return "admin";
	}
	
	@GetMapping("/logoutSuccess")
	public String showLogoutPage() {
		return "logout";
	}
	
	@GetMapping("/uploadImage")
	public String showUploadImagePage(Model model) {
		model.addAttribute("images", new Image());
		return "uploadImage";
	}
	
	@GetMapping("/createAccount")
	public String showCreateAccountPage(Model model, HttpSession session) {
		model.addAttribute("user", new User());
//		session.setAttribute("userList", userService.findUserById(1));
		return "createAccount";
	}

//	@PostMapping("/registerNewUser")
//	public String registerNewUser(@Valid @ModelAttribute("user") User newUser, 
//			BindingResult result) {
//		if (result.hasErrors()) {
//			return "register";
//		}
//		User user = userService.createUser(newUser);
//		return "redirect:/login";
//	}
}