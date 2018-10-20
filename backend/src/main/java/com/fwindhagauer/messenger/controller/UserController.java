package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.User;
import com.fwindhagauer.messenger.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserService, User> {

	public UserController(UserService concreteService) {
		super(concreteService);
	}
}
