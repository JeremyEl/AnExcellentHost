package org.perscholas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.perscholas.models.User;
import org.perscholas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@ControllerAdvice
public class HomeController {
	private UserService userService;
	
	@Autowired
	public void UserController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute
	public void attachModelAttribute(Model model) {
		model.addAttribute("greeting", "Users");
	}
	
	@GetMapping("/HomePage")
	public String showHomePage() {
//		model.addAttribute("user", new User());
//		session.setAttribute("userkey", userService.getAll());
		return "HomePage";
	}
	
	@GetMapping("/")
	public String showIndexPage() {
		return "HomePage";
	}
	
	@GetMapping("/UploadImage")
	public String showUploadImagePage() {
		return "UploadImage";
	}
	
	@GetMapping("/Login")
	public String showLoginPage() {
		return "Login";
	}
	
	@GetMapping("/CreateAccount")
	public String showCreateAccountPage(Model model, HttpSession session) {
		model.addAttribute("book", new User());
		session.setAttribute("userList", userService.findById(1));
		return "CreateAccount";
	}
//	private UserService userService;
//
//	@Autowired
//	public HomeController(UserService userservice) { this.userService = userservice;}
//
//	@GetMapping("/")
//	public String showIndexPage(Model model) {
//		model.addAttribute("user", new User());
//		return "HomePage";
//	}
//	
//	@GetMapping("/HomePage")
//	public String showHomePage() {
//		return "HomePage";
//	}
//	
//	@GetMapping("/Login")
//	public String showLoginPage() {
//		return "Login";
//	}
//	
//	@GetMapping("/CreateAccount")
//	public String showCreateAccountPage() {
//		return "CreateAccount";
//	}
//	
//	@GetMapping("/image1")
//	public String showImage1Page() {
//		return "image1";
//	}
//	
//	@ModelAttribute("userkey")
//	public Iterable<User> showUser(Model model){
//		return userService.getAll();
//	}
		
//	public User setUpUserForm() {
//		return userService.findUserByEmail("john@john.com");
//	
//	}
//	
//	
//	//This one might not be a good blind copy. Check for it's example implementation.
//	//Check on the Login page specifically
//	@PostMapping("/")
//	public String addUser(@Valid @ModelAttribute ("user") User user) {
//		System.out.println(user.toString());
//		User customer = userService.createUser(user);
//		return ("redirect:/");
//	}
}
