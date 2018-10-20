package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fwindhagauer.messenger.shared.UserHelper;
import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

	private String name;

	private String imagePath;

	private List<Chat> chats = new ArrayList<>();

	private List<Chat> favouriteChats = new ArrayList<>();

	private List<User> contacts = new ArrayList<>();

	private UserRole userRole;

	private boolean registrationAccepted;

	public User(){
		this.registrationAccepted = false;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany(mappedBy = "participants")
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public List<Chat> getPrivateChats(){
		List<Chat> privateChats = new ArrayList<>();
		for (Chat chat: this.chats ) {
			if(chat.getParticipants().size() <= 2){
				privateChats.add(chat);
			}
		}
		return privateChats;
	}

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public List<Chat> getGroupChats(){
		List<Chat> groupChats = new ArrayList<>();
		for (Chat chat: this.chats ) {
			if(chat.getParticipants().size() > 2){
				groupChats.add(chat);
			}
		}
		return groupChats;
	}

	public void addChat(Chat chat){
		if(!this.chats.contains(chat)){
			this.chats.add(chat);
		}
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany
	@JoinTable(name = "user_has_contact",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "contact_id")
	)
	public List<User> getContacts() {
		return contacts;
	}
	public void setContacts( List<User> contacts) {
		this.contacts = contacts;
	}

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY, value ="contacts")
	public List<User> getContactsJson() {
		return UserHelper.GetJsonUsers(this.contacts);
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

	@ManyToMany(mappedBy = "favouriteUsers")
	public List<Chat> getFavouriteChats() {
		return favouriteChats;
	}
	public void setFavouriteChats(List<Chat> favouriteChats) {
		this.favouriteChats = favouriteChats;
	}

	@ManyToOne
	@JoinColumn(name = "user_role_id")
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}


	/*@Transient
	public List<Chat> getPrivateChats() {
		return privateChats;
	}
	public void setPrivateChats(List<Chat> privateChats) {
		this.privateChats = privateChats;
	}

	@Transient
	public List<Chat> getGroupChats() {
		return groupChats;
	}
	public void setGroupChats(List<Chat> groupChats) {
		this.groupChats = groupChats;
	}*/
}
