package com.fwindhagauer.messenger.services;

import com.fwindhagauer.messenger.entitiy.Contact;
import com.fwindhagauer.messenger.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends BaseService<Contact, ContactRepository> {
}
