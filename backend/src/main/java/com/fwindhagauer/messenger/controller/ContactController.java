package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.Contact;
import com.fwindhagauer.messenger.services.ContactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController extends BaseController<ContactService, Contact> {
	private ContactService contactService;

	public ContactController(ContactService concreteService) {
		super(concreteService);
		this.contactService = concreteService;
	}
}
