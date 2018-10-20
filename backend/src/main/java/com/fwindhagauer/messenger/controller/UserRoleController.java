package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.UserRole;
import com.fwindhagauer.messenger.services.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class UserRoleController extends BaseController<UserRoleService, UserRole> {

	public UserRoleController(UserRoleService concreteService) {
		super(concreteService);
	}
}
