package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.Credentials;
import com.fwindhagauer.messenger.services.CredentialsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credentials")
public class CredentialsController extends BaseController<CredentialsService, Credentials> {
	public CredentialsController(CredentialsService concreteService) {
		super(concreteService);
	}
}
