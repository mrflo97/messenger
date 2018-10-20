package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.Message;
import com.fwindhagauer.messenger.entitiy.User;
import com.fwindhagauer.messenger.services.MessageService;
import com.fwindhagauer.messenger.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/message")
public class MessageController extends BaseController<MessageService, Message> {
	public MessageController(MessageService service){
		super(service);
	}

	/*@RequestMapping("/register/{id}")
	public SseEmitter RegisterSse(@PathVariable Integer id){
		if(this.emitters.containsKey(id)){
			return this.emitters.get(id);
		}
		SseEmitter emitter = new SseEmitter();

		this.emitters.put(id, emitter);
		emitter.onCompletion(() -> this.emitters.remove(emitter));
		return emitter;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity NewMessage(@RequestBody Message message){
		int receiverId = message.getReceiver().getId();
		ResponseEntity response = super.addEntity(message);
		Message savedMessage = (Message)response.getBody();
		if(this.emitters.containsKey(receiverId)){
			try {
				this.emitters.get(receiverId).send(SseEmitter.event().name("private-message").data(savedMessage));
			}
			catch(IllegalStateException e){
				this.emitters.remove(receiverId);
			}
			catch (IOException e) {
				e.printStackTrace();

			}
		}
		return response;
	}*/
}
