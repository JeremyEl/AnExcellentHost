package com.jeremyeliassen.anexcellenthost.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tags")
public class Tag {
	
	@Id
	@NotNull
	@Size(max=40)
	@Column(name="term")
	private String term;
	@Column(name="voteCount")
	private int vote;
	@ManyToMany(mappedBy = "tagAssignment")
	private List<Image> imageList;
	
	
	public Tag() {
		this.vote = 0;
	}
	
	public Tag(String term) {
		this.term = term;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	
	

}
