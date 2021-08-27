package com.jeremyeliassen.anexcellenthost.servicesimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremyeliassen.anexcellenthost.models.Image;
import com.jeremyeliassen.anexcellenthost.repositories.ImageRepository;
import com.jeremyeliassen.anexcellenthost.services.ImageService;


@Service
public class ImageServiceImplement implements ImageService {
	
	private ImageRepository imageRepository;

	@Autowired
	public ImageServiceImplement(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	
	@Override
	public Image createImage(Image image) {
		return imageRepository.save(image);
	}

	@Override
	public Image findImageById(int imageId) {
		Optional<Image> optImage = imageRepository.findById(imageId);
		if (optImage.isPresent()) {
			return optImage.get();
		}
		return null;
	}

	@Override
	public Image findImageByName(String imageName) {
		Optional<Image> optImage = Optional.ofNullable(imageRepository.findByImageName(imageName));
		if (optImage.isPresent()) {
			return optImage.get();
		}
		return null;
	}

	//It's true, this one is unimplemented. I couldn't find a way to connect
	//user to image and get that all looking nice on the account page, 
	//but here is the simple operation to delete the image posted.
	//Should be done by only the user that posted it, but that's done in the controller.
	@Override
	public void removeImage(Image image) {
		imageRepository.delete(image);
	}
	
	//It's true that this is essentially a duplicate of the createImage method above
	//but that's because I made the other one first and don't want to go through and
	//hunt down every change after swapping to this one with what little time I have left.
	@Override
	public Image save(Image image) {
		return imageRepository.save(image);
	}

}
