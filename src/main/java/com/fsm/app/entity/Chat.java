package com.fsm.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Chat {
	
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
/*	@ManyToMany(mappedBy="chatsSend")
	private List<User> userSend;*/
	

	@ManyToOne
	private User userSend;
	
	@ManyToOne
	private User userRecieved;
	
	
	public User getUserSend() {
		return userSend;
	}

	public void setUserSend(User userSend) {
		this.userSend = userSend;
	}

	public User getUserRecieved() {
		return userRecieved;
	}

	public void setUserRecieved(User userRecieved) {
		this.userRecieved = userRecieved;
	}
	
	private Date time;
	
	@Column(name="message", length=50)
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
