package com.jeremyeliassen.anexcellenthost.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.jeremyeliassen.anexcellenthost.models.Comment;
import com.jeremyeliassen.anexcellenthost.services.CommentService;

@SpringBootTest
public class CommentIT {

	private CommentService commentService;
	
	@Autowired
	public CommentIT(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@Test
	void testCreateComment() {
		Comment testComment = new Comment("This is a test Comment.");
		testComment = commentService.createComment(testComment);
		String testBody = "This is a test Comment.";
		String testReceive = commentService.findByCommentId(testComment.getCommentId()).getCommentBody();
		assertEquals(testBody, testReceive);
	}
	
}
