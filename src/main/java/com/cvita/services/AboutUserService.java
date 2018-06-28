package com.cvita.services;

import com.cvita.models.AboutUser;
import com.cvita.models.User;

import java.util.List;

public interface AboutUserService {
	void saveAboutUser(AboutUser aboutUser);
	AboutUser getAboutAboutUserById(String id);
	void addNameToAboutUser(String idUser, String idHardSkill);
}
