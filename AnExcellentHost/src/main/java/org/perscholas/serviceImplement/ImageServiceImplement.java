package org.perscholas.serviceImplement;

import java.util.Optional;

import org.perscholas.models.Image;
import org.perscholas.models.User;
import org.perscholas.repositories.ImageRepository;
import org.perscholas.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		//COMMENT THIS LATER ABOUT THE OPTIONAL BIT
		Optional<Image> optImage = Optional.ofNullable(imageRepository.findByImageName(imageName));
		if (optImage.isPresent()) {
			return optImage.get();
		}
		return null;
	}

	@Override
	public void removeImage(Image image) {
		imageRepository.delete(image);
		
	}
	
	@Override
	public Image save(Image image) {
		return imageRepository.save(image);
	}

}
