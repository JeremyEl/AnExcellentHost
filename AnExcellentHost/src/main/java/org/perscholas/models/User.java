package org.perscholas.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User implements Serializable {
	
//	@OneToMany(targetEntity = Image.class)
//	private 
	
//	@ManyToMany(targetEntity = Friend.class)
//	@JoinTable(name = "friends",
//	joinColumns = {
//		@JoinColumn(name = "fk_user")
//	},
//	inverseJoinColumns = {
//		@JoinColumn(name = "fk_friend")
//	})
//	private List<Friend> friends = new ArrayList<>();
	
//	@OneToMany(targetEntity = Comments.class)
//	private
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotEmpty(message="Cannot be nothing")
	@Size(min=2, max=50, message="Must be 2-50 characters")
	@Column(name = "name")
	private String name;
//	@NotEmpty(message="must not be empty")
//	private String email;
	@Size(min=2, max=50, message="Must be 2-50 characters")
	@Column(name = "password")
	private String password;
	
	public User() {}

//	public User(String name, String email, String password) {
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
//		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
