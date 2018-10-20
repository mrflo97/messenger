package com.fwindhagauer.messenger.shared;

import com.fwindhagauer.messenger.entitiy.UserRole;

import java.util.ArrayList;
import java.util.List;

public class JsonUser {
	private String name;

	private String imagePath;

	private List<JsonUser> contacts = new ArrayList<>();

	private UserRole userRole;

	private boolean registrationAccepted;
}
