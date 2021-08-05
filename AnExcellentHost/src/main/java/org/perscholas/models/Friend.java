package org.perscholas.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class Friend implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//TODO DO THIS ONE LATER!
	@Id
	private int friendId;

}
