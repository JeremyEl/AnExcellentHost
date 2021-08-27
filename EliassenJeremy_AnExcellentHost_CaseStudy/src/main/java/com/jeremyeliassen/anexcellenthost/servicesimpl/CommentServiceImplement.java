package com.jeremyeliassen.anexcellenthost.servicesimpl;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
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

	//Unimplemented. Couldn't find a way to connect it to Admin-only powers 
	//and also have a button on the comments only admins can see.
	//A tale of scope creep that was just outside the project.
	@Override
	public void removeComment(Comment comment) {
		commentRepository.delete(comment);		
	}

	@Override
	public Comment findByCommentId(int commentId) throws EntityNotFoundException {
		Optional<Comment> optComment = commentRepository.findById(commentId);
		if(optComment.isPresent()) {
			return optComment.get();
		}
		//Custom Exception Here
		//I'm about 50% sure this counts as a custom exception.
		//After all, it has it's own message!
		throw new EntityNotFoundException("Comment Not Found!");		
	}
}
