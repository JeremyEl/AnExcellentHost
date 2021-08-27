package com.jeremyeliassen.anexcellenthost.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="images")
public class Image implements Serializable {
	
	//This class utilizes a BLOB whic stores the actual image itself into the database.
	//It works for a project this small, but I don't think it's scalable.
	//Also imageName and imageFileName are somewhat reversed, but I decided not to fix it.
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "image_id")
	private int imageId;
	@Column(name = "image_name")
	private String imageName;
	@Column(name = "description")
	private String description;
	@Column(name = "image_file_name")
	private String imageFileName;
	@Lob
    @Column(columnDefinition="MEDIUMBLOB")
	private String imageItself;
	@OneToMany(targetEntity = Comment.class)
	private List<Comment> comments;
	@ManyToMany
	@JoinTable(
			name = "tagAssignment",
			joinColumns = @JoinColumn(name = "image_id"),
			inverseJoinColumns = @JoinColumn(name = "term"))
	private List<Tag> tagAssignment;
	@ManyToOne
	private User userPoster;
	
	public Image() {}
	
	public Image(int imageId, String imageName, String description) {
		this.imageId = imageId;
		this.imageName = imageName;
		this.description = description;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageItself() {
		return imageItself;
	}

	public void setImageItself(String imageItself) {
		this.imageItself = imageItself;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Tag> getTagAssignment() {
		return tagAssignment;
	}

	public void setTagAssignment(List<Tag> tagAssignment) {
		this.tagAssignment = tagAssignment;
	}

	public User getUserPoster() {
		return userPoster;
	}

	public void setUserPoster(User userPoster) {
		this.userPoster = userPoster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + imageId;
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imageId != other.imageId)
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		return true;
	}
	
}
