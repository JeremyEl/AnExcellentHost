package com.jeremyeliassen.anexcellenthost.services;

import com.jeremyeliassen.anexcellenthost.models.Comment;

public interface CommentService {

	Comment createComment(Comment comment);
	void removeComment(Comment comment);
	Comment findByCommentId(int commentId);
}
