package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.PrivateMessage;
import com.fwindhagauer.messenger.services.BaseService;
import com.fwindhagauer.messenger.services.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private-msg")
public class PrivateMessageController extends BaseController<PrivateMessageService, PrivateMessage> {

	public PrivateMessageController(PrivateMessageService service){
		super(service);
	}


}
