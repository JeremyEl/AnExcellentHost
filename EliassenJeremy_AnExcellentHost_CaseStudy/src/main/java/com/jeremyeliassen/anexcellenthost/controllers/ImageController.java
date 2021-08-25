package com.jeremyeliassen.anexcellenthost.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeremyeliassen.anexcellenthost.models.Image;
import com.jeremyeliassen.anexcellenthost.repositories.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
//import javax.validation.Valid;

@Controller
public class ImageController {
	
	ImageRepository imageRepository;
	private static final Logger LOGGER = Logger.getLogger(ImageController.class.getName());
	
	@Autowired
	public ImageController(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	
	
	@PostMapping("/saveImage")
	public String fileUpload(@RequestParam("images") MultipartFile[] files, Model model, Image image,
			RedirectAttributes redirect) throws IOException {
		LOGGER.log(Level.INFO, "fileUpload method called.");
		LOGGER.log(Level.INFO, "Image Name: {0}", image.getImageName());
		Image newImage = null;
		String originalFileName = null;
		for (MultipartFile file : files) {
			originalFileName = Objects.requireNonNull(file.getOriginalFilename(), "Please select at least one file.");
			if (!originalFileName.isEmpty()) {
				// The following section will save the image/file to the database
				// *******************************************************************************
				image.setImageName(file.getOriginalFilename());
				// The byte[] is encoded as a string which allows it to be retrieved and
				// rendered
				// in the view using an <img> tag
				image.setImageItself(Base64.getEncoder().encodeToString(file.getBytes()));
//				image.setUserPoster(null);
				newImage = imageRepository.save(image);
				
				// *******************************************************************************
//				System.out.println(newImage.getUserPoster().getUsername());
			} else {
				redirect.addFlashAttribute("msg", "Please select at least one file.");
				return "redirect:./";
				
			}
		}
		model.addAttribute("msg", "Multiple files uploaded successfully");
		model.addAttribute("newImage", newImage);
		return "view_image_detail";
	}
	
	@GetMapping("/view_image_detail/{imageId}")
	public String viewImageDetial(@PathVariable(value="imageId") int imageId, Model model) {
		Image currentImage = imageRepository.findByImageId(imageId);	
		model.addAttribute("newImage", currentImage);
		
		return "view_image_detail";
	}
	
//	@GetMapping("/displayNewImage")
//	public String displayImage(Model model) {
//		Image image = null;
//		Optional<Image> foundImage = imageRepository.findById(1);
//		if(foundImage.isPresent()) {
//			image = foundImage.get();
//		}
//		model.addAttribute("image", image);
//		return "displayImage";
//	}
	
	@GetMapping("/image1")
	public String dispalyExampleImage() {
		return "image1";
	}
	
//	@PostMapping("/incrementTag")
//	public String


}
