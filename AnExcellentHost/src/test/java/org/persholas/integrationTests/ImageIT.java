package org.persholas.integrationTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.perscholas.config.WebAppConfig;
import org.perscholas.models.Image;
import org.perscholas.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ImageIT {
	private ImageService imageService;
	
	@Autowired
	public ImageIT(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@Test
	void TestFindImageById() {
		Image newImage = new Image();
		newImage.setImageId(1);
		newImage.setImageName("bizza.jpg");
		newImage.setDescription("This is merely a test");
		Image saveImage = imageService.save(newImage);
		Image testImage = imageService.findImageById(saveImage.getImageId());
		assertEquals(saveImage, testImage);
	}
	

}
