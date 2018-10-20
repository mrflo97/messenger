package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

	private String name;

	private String pw;

	private String salt;

	private UserRole userRole;

	private boolean registrationAccepted;

	private String imagePath;

	private List<Contact> contacts = new ArrayList<>();

	private List<Chat> chats = new ArrayList<>();

	public User(){
		this.registrationAccepted = false;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String username) {
		this.name = username;
	}

	@Column(name = "pw", nullable = false)
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Column(name = "salt", nullable = false)
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	@ManyToOne
	@JoinColumn(name = "user_role_id", nullable = false)
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@OneToMany(mappedBy = "owner", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts( List<Contact> contacts) {
		this.contacts = contacts;
	}

	@OneToMany(mappedBy = "owner", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	@Column(name = "registration_accepted", nullable = false)
	public boolean isRegistrationAccepted() {
		return registrationAccepted;
	}
	public void setRegistrationAccepted(boolean registrationAccepted) {
		this.registrationAccepted = registrationAccepted;
	}

	@Column(name = "image_path", nullable = false)
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
