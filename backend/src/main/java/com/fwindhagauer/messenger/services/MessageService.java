package com.fwindhagauer.messenger.services;

import com.fwindhagauer.messenger.entitiy.Message;
import com.fwindhagauer.messenger.entitiy.User;
import com.fwindhagauer.messenger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends BaseService<Message, MessageRepository> {

	@Autowired
	private UserService userService;

	@Override
	public Message saveEntity(Message message) {
		if(message.getSender() == null && message.getSenderUserId() != -1) {
			User sender = userService.findById(message.getSenderUserId());
			message.setSender(sender);
		}
		if(message.getSender() != null && message.getSenderUserId() == -1) {
			message.setSenderUserId(message.getSender().getId());
		}
		return super.saveEntity(message);
	}
}
