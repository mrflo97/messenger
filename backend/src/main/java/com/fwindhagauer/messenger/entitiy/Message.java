package com.fwindhagauer.messenger.entitiy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message extends BaseEntity {
	private String text;

	private String sender;

	@JsonBackReference
	private Chat chat;

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

	@Column(name = "sender")
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
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
}