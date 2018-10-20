package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat extends BaseEntity {

	private List<Message> messages = new ArrayList<>();

	private boolean favourite = false;

	private Contact participant;

	private User owner;

	public Chat(){
		super();
	}

	@OneToMany(mappedBy = "chat")
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages( List<Message> messages)
	{
		this.messages = messages;
	}

	@Column(name = "favourite")
	public boolean isFavourite() {
		return favourite;
	}
	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	@ManyToOne
	@JoinColumn(name = "participant_id")
	public Contact getParticipant() {
		return participant;
	}
	public void setParticipant(Contact participant) {
		this.participant = participant;
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "owner_id")
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
