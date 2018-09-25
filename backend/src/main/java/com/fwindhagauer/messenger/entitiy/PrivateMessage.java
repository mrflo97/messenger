package com.fwindhagauer.messenger.entitiy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "private_message")
public class PrivateMessage extends BaseEntity{
	private String content;

	private User receiver;

	private User sender;

	private Date sentTime;

	public PrivateMessage(String content, User receiver, User sender, Date sentTime) {
		this.content = content;
		this.receiver = receiver;
		this.sender = sender;
		this.sentTime = sentTime;
	}

	public PrivateMessage() {

	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "receiver_user_id", nullable = false)
	public User getReceiver_user_id() {
		return receiver;
	}

	public void setReceiver_user_id(User receiver) {
		this.receiver = receiver;
	}

	@ManyToOne
	@JoinColumn(name = "sender_user_id", nullable = false)
	public User getSender_user_id() {
		return sender;
	}

	public void setSender_user_id(User sender) {
		this.sender = sender;
	}

	@Column(name = "sent_time")
	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}
}
