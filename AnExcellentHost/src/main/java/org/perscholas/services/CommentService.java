package org.perscholas.services;

import org.perscholas.models.Comment;

public interface CommentService {

	Comment createComment(Comment comment);
	Comment findCommentById(int commentId);
	void removeImage(Comment cmment);
}
