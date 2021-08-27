package com.jeremyeliassen.anexcellenthost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremyeliassen.anexcellenthost.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	void findByCommentId(int commentId);

}