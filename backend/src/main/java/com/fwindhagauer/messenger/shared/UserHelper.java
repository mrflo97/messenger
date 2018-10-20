package com.fwindhagauer.messenger.shared;

import com.fwindhagauer.messenger.entitiy.User;

import java.util.ArrayList;
import java.util.List;

public class UserHelper {
	public static User GetJsonUser(User user){
		User jsonUser = new User();
		jsonUser.setId(user.getId());
		jsonUser.setRegistrationAccepted(user.isRegistrationAccepted());
		jsonUser.setImagePath(user.getImagePath());
		jsonUser.setName(user.getName());
		jsonUser.setUserRole(user.getUserRole());
		return jsonUser;
	}

	public static List<User> GetJsonUsers(List<User> users)	{
		List<User> newUsers = new ArrayList<>();
		for (User user : users) {
			newUsers.add(GetJsonUser(user));
		}
		return newUsers;
	}
}
