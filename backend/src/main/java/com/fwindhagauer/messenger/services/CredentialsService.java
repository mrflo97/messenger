package com.fwindhagauer.messenger.services;

import com.fwindhagauer.messenger.entitiy.Credentials;
import com.fwindhagauer.messenger.entitiy.User;
import com.fwindhagauer.messenger.repository.CredentialsRepositoy;
import org.springframework.stereotype.Service;

@Service
public class CredentialsService extends BaseService<Credentials, CredentialsRepositoy> {
	public Credentials findByUser(User user){
		return this.concreteRepository.findByUser(user);
	}
}
