package com.fwindhagauer.messenger.entitiy;

import java.util.List;

public class Group extends BaseEntity {
	private List<Contact> participants;

	private List<Message> messages;

	private String imagePath;

	private boolean favourite;

	public Group(){}
}
