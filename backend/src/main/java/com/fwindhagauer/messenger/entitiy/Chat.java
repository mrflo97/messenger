package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fwindhagauer.messenger.shared.UserHelper;
import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat extends BaseEntity {

	private String imagePath;

	private List<Message> messages = new ArrayList<>();

	private List<User> participants = new ArrayList<>();

	private List<User> favouriteUsers = new ArrayList<>();

	public Chat(){
		super();
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany
	@JoinTable(name = "chat_user_favourite",
			joinColumns = @JoinColumn(name = "chat_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	public List<User> getFavouriteUsers() {
		return favouriteUsers;
	}
	public void setFavouriteUsers(List<User> favouriteUsers) {
		this.favouriteUsers = favouriteUsers;
	}

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY, value = "favouriteUsers")
	public List<User> getFavouriteUsersJson(){
		return UserHelper.GetJsonUsers(this.favouriteUsers);
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany
	@JoinTable(name = "chat_has_user",
			joinColumns = @JoinColumn(name = "chat_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	public List<User> getParticipants() {
		return participants;
	}
	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY, value = "participants")
	public List<User> getParticipantsJson() {
		return UserHelper.GetJsonUsers(this.participants);
	}

	@Column(name = "image_path")
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@OneToMany(mappedBy = "chat")
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages( List<Message> messages)
	{
		this.messages = messages;
	}
}
