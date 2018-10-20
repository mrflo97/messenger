package com.fwindhagauer.messenger.services;

import com.fwindhagauer.messenger.entitiy.Message;
import com.fwindhagauer.messenger.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends BaseService<Message, MessageRepository> {
	/*@Override
	public Message saveEntity(Message message) {
		message.getChat().addMessaage(message);
		return super.saveEntity(message);
	}*/
}
