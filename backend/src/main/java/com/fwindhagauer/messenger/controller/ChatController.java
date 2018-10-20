package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.Chat;
import com.fwindhagauer.messenger.services.ChatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController extends BaseController<ChatService, Chat> {
	public ChatController(ChatService concreteService) {
		super(concreteService);
	}
}
