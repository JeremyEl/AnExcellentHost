package com.jeremyeliassen.anexcellenthost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremyeliassen.anexcellenthost.models.Image;



public interface ImageRepository extends JpaRepository<Image, Integer> {
	Image findByImageId(int imageId);
	Image findByImageName(String imageName);

}
