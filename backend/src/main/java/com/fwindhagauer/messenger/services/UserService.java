package com.fwindhagauer.messenger.services;

import com.fwindhagauer.messenger.entitiy.User;
import com.fwindhagauer.messenger.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {
}
