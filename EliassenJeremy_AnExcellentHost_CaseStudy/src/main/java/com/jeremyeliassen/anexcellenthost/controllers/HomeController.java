package com.jeremyeliassen.anexcellenthost.controllers;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.jeremyeliassen.anexcellenthost.models.Image;
import com.jeremyeliassen.anexcellenthost.models.User;
import com.jeremyeliassen.anexcellenthost.services.ImageService;


@Controller
public class HomeController {
	
	//The reason why I have 3 controllers is because I didn't want to have 1 obscenely long one.
	//This controller deals mostly with the pages and simple stuff. Navigation, login/logout, etc.
	//Images takes care of everything to do with images, including posting comments and tags.
	//The user controller is all about the user, including account, editing, and deleting.

	private ImageService imageService;
	
	@Autowired
	public HomeController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	//You'll notice here there's this bit about caring who the user is and how it's present nowhere else.
	//Really, it's legacy code from the example I pulled it from and left "because I might make use of 
	//it elsewhere". I decided not to make use of it, mostly due to unfamiliarity with how, where, and why.
	//But if I ever do gain that familiarity, I'll be glad I still have this around.
	//But yeah, ultimately, because you only ever hit the "/" page basically once, it doesn't really do anything.
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
		for (int i = 1; i < 11; i++) {
			Image imageGet = imageService.findImageById(i);
			model.addAttribute("image"+i, imageGet);
		}
		return "home";
	}
	
	//The loop here and in the other one is a workaround. The intent is to show images on the 
	//front page. Ideally, the images presented would be random from the database, and far more numerous.
	//This merely makes it show the first ten because I couldn't figure out how to do the other option.
	@GetMapping("/home")
	public String otherShowHomePage(Model model) {
		for (int i = 1; i < 11; i++) {
			Image imageGet = imageService.findImageById(i);
			model.addAttribute("image"+i, imageGet);
		}
		return "home";
	}
	
	//The login page was remade to enter because Spring Security was being annoying and this
	//was my solution to its antics. It takes over /login in a way I did not like, so here it goes.
	@GetMapping("/login")
	public String showLoginPage() {
		return "enter";
	}
	
	@GetMapping("/enter")
	public String showActualLoginPage() {
		return "enter";
	}
	
	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		return "access_denied";
	}
	
	@GetMapping("/logoutSuccess")
	public String showLogoutPage() {
		return "logout";
	}
	
	@GetMapping("/upload")
	public String showUploadImagePage(Model model) {
		model.addAttribute("images", new Image());
		return "upload";
	}
	
	@GetMapping("/create_account")
	public String showCreateAccountPage(Model model, HttpSession session) {
		model.addAttribute("user", new User());
		return "create_account";
	}

}