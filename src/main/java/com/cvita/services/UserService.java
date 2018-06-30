package com.cvita.services;

import com.cvita.models.AboutUser;
import com.cvita.models.HrSearchResult;
import com.cvita.models.User;

import java.util.List;
import java.util.Map;

public interface UserService {
	void saveUser(User user);
	User getUserById(String id);
	List<User> getAllUsers();
	void removeUserById(String id);
	void saveAboutUser(String idUser,AboutUser aboutUser);
	void addHardSkillToAboutUserByUserId(String idUser, List<String> idHardSkills);

	Map<Map<Integer, Integer>, Map<User, List<String>>> hrSearch(List<String> search);
	HrSearchResult hrSearch2(List<String> search);


}
