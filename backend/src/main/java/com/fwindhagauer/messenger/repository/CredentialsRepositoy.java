package com.fwindhagauer.messenger.repository;

import com.fwindhagauer.messenger.entitiy.Credentials;
import com.fwindhagauer.messenger.entitiy.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepositoy extends BaseRepository<Credentials> {
	Credentials findByUser(User user);
}
