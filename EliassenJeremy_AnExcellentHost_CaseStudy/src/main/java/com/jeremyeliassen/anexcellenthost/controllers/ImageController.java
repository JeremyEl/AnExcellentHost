package com.jeremyeliassen.anexcellenthost.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jeremyeliassen.anexcellenthost.models.Comment;
import com.jeremyeliassen.anexcellenthost.models.Image;
import com.jeremyeliassen.anexcellenthost.models.Tag;
import com.jeremyeliassen.anexcellenthost.repositories.CommentRepository;
import com.jeremyeliassen.anexcellenthost.repositories.ImageRepository;
import com.jeremyeliassen.anexcellenthost.repositories.TagRepository;
import com.jeremyeliassen.anexcellenthost.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ImageController {
	
	ImageRepository imageRepository;
	CommentRepository commentRepository;
	TagRepository tagRepository;
	private static final Logger LOGGER = Logger.getLogger(ImageController.class.getName());
	
	@Autowired
	public ImageController(ImageRepository imageRepository, CommentRepository commentRepository, TagRepository tagRepository) {
		this.imageRepository = imageRepository;
		this.commentRepository = commentRepository;
		this.tagRepository = tagRepository;
	}
	
	//This method was adapted from another project. I modified a bit here to add information about who the user
	//who posted the image is. Otherwise, this commits the actual file itself to the database with 
	//the two parameters the user provides, the name of the file on their computer, and 2 assigned params.
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
				image.setImageName(file.getOriginalFilename());
				// The byte[] is encoded as a string which allows it to be retrieved and
				// rendered in the view using an <img> tag
				image.setImageItself(Base64.getEncoder().encodeToString(file.getBytes()));
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				CurrentUser thisUser = (CurrentUser) authentication.getPrincipal();
				image.setUserPoster(thisUser.getUser());
				newImage = imageRepository.save(image);
			} else {
				redirect.addFlashAttribute("msg", "Please select at least one file.");
				return "redirect:./";
				
			}
		}
		model.addAttribute("msg", "Multiple files uploaded successfully");
		model.addAttribute("newImage", newImage);
		return "view";
	}
	
	
	@GetMapping("/view/{imageId}")
	public String viewImageDetail(@PathVariable(value="imageId") int imageId, Model model) {
		Image currentImage = imageRepository.findByImageId(imageId);	
		model.addAttribute("newImage", currentImage);
		model.addAttribute("comment", new Comment());
		return "view";
	}	
	
	
	@PostMapping("/addComment")
	public String viewNewerImageDetail(@RequestParam int imageId,
				@RequestParam String commentBody, Model model) {
		Image currentImage = imageRepository.findByImageId(imageId);	
		model.addAttribute("newImage", currentImage);
		Comment postedComment = new Comment();
		postedComment.setCommentBody(commentBody);
		postedComment.setImagePost(currentImage);
		currentImage.getComments().add(postedComment);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
		postedComment.setcommentPoster(currentUser.getUser());
		
		commentRepository.save(postedComment);
		imageRepository.save(currentImage);
	
		return "view";
	}
	
	//This had to have a provision for if the tag or image did not exist.
	//This is due to the nature of the joins in the database and how they interact.
	@PostMapping("/addTag")
	public String addTag(@RequestParam int imageId,
			@RequestParam String term, Model model) {
		Image currentImage = imageRepository.findByImageId(imageId);	
		model.addAttribute("newImage", currentImage);
		Tag additionalTag = new Tag();
		additionalTag.setTerm(term);
		if(currentImage.getTagAssignment() == null) {
			currentImage.setTagAssignment(new ArrayList<Tag>());
		}
		if(additionalTag.getImageList() == null) {
			additionalTag.setImageList(new ArrayList<Image>());
		}
		
		additionalTag.getImageList().add(currentImage);
		currentImage.getTagAssignment().add(additionalTag);
		tagRepository.save(additionalTag);
		imageRepository.save(currentImage);
		
		return "view";
	}

}
