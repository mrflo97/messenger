package com.fwindhagauer.messenger.controller;

import com.fwindhagauer.messenger.entitiy.UserRole;
import com.fwindhagauer.messenger.services.UserRoleService;

public class UserRoleController extends BaseController<UserRoleService, UserRole> {

	public UserRoleController(UserRoleService concreteService) {
		super(concreteService);
	}
}
