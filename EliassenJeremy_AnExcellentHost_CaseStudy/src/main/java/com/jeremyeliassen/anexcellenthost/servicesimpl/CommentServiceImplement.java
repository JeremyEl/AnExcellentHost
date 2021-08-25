package com.jeremyeliassen.anexcellenthost.servicesimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremyeliassen.anexcellenthost.models.Comment;
import com.jeremyeliassen.anexcellenthost.repositories.CommentRepository;
import com.jeremyeliassen.anexcellenthost.services.CommentService;

@Service
public class CommentServiceImplement implements CommentService {
	
	private CommentRepository commentRepository;
	
	@Autowired
	public CommentServiceImplement(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public Comment createComment(Comment comment) {
		
		return commentRepository.save(comment);
	}

//	@Override
//	public Comment findByCommentId(int commentId) {
//		
//		return commentRepository.findById(commentId);
//	}

	@Override
	public void removeComment(Comment comment) {
		commentRepository.delete(comment);		
	}

}
