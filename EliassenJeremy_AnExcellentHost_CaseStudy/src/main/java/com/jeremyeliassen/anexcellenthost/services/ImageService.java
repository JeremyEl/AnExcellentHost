package com.jeremyeliassen.anexcellenthost.services;

import com.jeremyeliassen.anexcellenthost.models.Image;

public interface ImageService {

	Image createImage(Image image);
	Image findImageById(int imageId);
	Image findImageByName(String imageName);
	void removeImage(Image image);
	Image save(Image image);
}

