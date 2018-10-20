package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message extends BaseEntity {
	private String text;

	private User sender;

	private Chat chat;

	private int senderUserId = -1;

	public Message(){
		super();
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "chat_id", referencedColumnName = "id")
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "sender_id")
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}

	public int getSenderUserId() {
		return senderUserId;
	}
	public void setSenderUserId(int senderUserId) {
		this.senderUserId = senderUserId;
	}
}