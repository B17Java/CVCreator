package com.cvita.services;

import com.cvita.models.User;

import java.util.List;

public interface UserService {
	void saveUser(User user);
	User getUserById(String id);
	List<User> getAllUsers();
	void removeUserById(String id);

	void addNameToAboutUser(String iduser, String idhardskill);
}
