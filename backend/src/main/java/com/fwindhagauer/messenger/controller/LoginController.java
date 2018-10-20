package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.Credentials;
import com.fwindhagauer.messenger.entitiy.User;
import com.fwindhagauer.messenger.services.CredentialsService;
import com.fwindhagauer.messenger.services.UserService;
import com.fwindhagauer.messenger.shared.Login;
import com.fwindhagauer.messenger.shared.Tools;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private CredentialsService credentialsService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody Login login){
		User user = userService.findByName(login.getName());
		Credentials cred = credentialsService.findByUser(user);
		if(user != null && cred != null &&  login.getPw().equals(cred.getPw())){
			return ResponseEntity.ok(user);
		}
		return new ResponseEntity(HttpStatus.FORBIDDEN);
	}
}
