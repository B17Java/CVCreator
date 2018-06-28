package com.cvita.services.impl;

import com.cvita.models.AboutUser;
import com.cvita.models.User;
import com.cvita.repositories.UserRepository;
import com.cvita.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUserById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addNameToAboutUser(String id, String name) {
        getUserById(id).getAboutUser().setName(name);
    }
}
