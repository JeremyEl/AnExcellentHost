package org.perscholas.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="comments")
public class Comment implements Serializable {
	
//	@ManyToOne(targetEntity = User.class)
	
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "commentId")
	private int commentId;
	@NotEmpty
	@Size(max=3000)
	@Column(name = "commentBody")
	private String commentBody;
	
	public Comment () {}
	
	public Comment(int commentId, String commentBody) {
		this.commentId = commentId;
		this.commentBody = commentBody;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	
	
}
