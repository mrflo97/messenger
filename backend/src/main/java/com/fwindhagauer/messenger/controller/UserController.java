package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.User;
import com.fwindhagauer.messenger.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<UserService, User> {

	public UserController(UserService concreteService) {
		super(concreteService);
	}
}
