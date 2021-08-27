package com.jeremyeliassen.anexcellenthost.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.jeremyeliassen.anexcellenthost.models.Tag;
import com.jeremyeliassen.anexcellenthost.services.TagService;

@SpringBootTest
public class TagIT {

	private TagService tagService;
	
	@Autowired
	public TagIT(TagService tagService) {
		this.tagService = tagService;
	}
	
	@Test
	void testCreateTag() {
		Tag testTag = new Tag("This is a test Tag");
		testTag = tagService.createTag(testTag);
		String controlTag = "This is a test Tag";
		String receiveTag = tagService.findByTerm(testTag.getTerm()).getTerm();
		assertEquals(controlTag, receiveTag);
		
	}
	
	
}
