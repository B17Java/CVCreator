package com.cvita.services.impl;

import com.cvita.models.AboutUser;
import com.cvita.models.User;
import com.cvita.repositories.AboutUserRepository;
import com.cvita.repositories.UserRepository;
import com.cvita.services.AboutUserService;
import com.cvita.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutUserServiceImpl implements AboutUserService {

    @Autowired
    AboutUserRepository aboutUserRepository;

    @Override
    public void saveAboutUser(AboutUser aboutUser) {
        aboutUserRepository.save(aboutUser);
    }

    @Override
    public AboutUser getAboutAboutUserById(String id) {
        return aboutUserRepository.findById(id).get();
    }

    @Override
    public void addNameToAboutUser(String idUser, String idHardSkill) {

    }
}
