package org.perscholas.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.perscholas.models.Image;
import org.perscholas.services.ImageService;

@Controller
public class ImageController {

	private ImageService imageService;
	
	@Autowired
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}

	@PostMapping("/createImage")
	public String createImage(@Valid @ModelAttribute("image") Image image,
			BindingResult errors) {
		System.out.println("has errors? " + errors.hasErrors());
		if( errors.hasErrors()) {
			return"index";
		}

		imageService.createImage(image);		
		return "redirect:/";
	}


}
