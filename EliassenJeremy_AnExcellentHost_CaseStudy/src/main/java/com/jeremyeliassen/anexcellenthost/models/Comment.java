package com.jeremyeliassen.anexcellenthost.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@Entity
@Table(name="comments")
public class Comment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "commentId")
	private int commentId;
	@NotEmpty
	@Size(max=3000)
	@Column(name = "commentBody")
	private String commentBody;
	@ManyToOne
	private Image imagePost;
	@ManyToOne
	private User commentPoster;
	
	public Comment () {}
	
	public Comment(String commentBody) {
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

	public Image getImagePost() {
		return imagePost;
	}

	public void setImagePost(Image imagePost) {
		this.imagePost = imagePost;
	}

	public User getcommentPoster() {
		return commentPoster;
	}

	public void setcommentPoster(User commentPoster) {
		this.commentPoster = commentPoster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
