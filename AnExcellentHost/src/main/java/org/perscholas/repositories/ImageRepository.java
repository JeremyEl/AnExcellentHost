package org.perscholas.repositories;

import org.perscholas.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
	Image findImageById(int imageId);
	Image findImageByName(String imageName);

}
