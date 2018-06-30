package com.cvita.services.impl;

import com.cvita.models.AboutUser;
import com.cvita.models.HardSkill;
import com.cvita.models.User;
import com.cvita.repositories.HardSkillRepository;
import com.cvita.repositories.UserRepository;
import com.cvita.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HardSkillRepository hardSkillRepository;

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
    public void saveAboutUser(String idUser, AboutUser aboutUser) {
        User user = getUserById(idUser);
        user.setAboutUser(aboutUser);
        userRepository.save(user);
    }

    @Override
    public void addHardSkillToAboutUserByUserId(String idUser, List<String> idHardSkills) {
        AboutUser aboutUser = userRepository.findById(idUser).get().getAboutUser();
        if (aboutUser == null) {
            aboutUser = new AboutUser();
        }
        aboutUser.getHardSkills().addAll((Collection<? extends HardSkill>) hardSkillRepository.findAllById(idHardSkills));
        saveAboutUser(idUser, aboutUser);
    }

    @Override
    public Map<User, List<String>> hrSearch(List<String> searchSkills) {
        List<User> users = getAllUsers();
        Map<User, List<String>> result = new HashMap<>();
        for (User user : users) {
            if (user.getAboutUser() != null) {
                for (HardSkill userHardSkill : user.getAboutUser().getHardSkills()) {
                    List<String> coincidedSkills = new ArrayList<>();
                    for (String searchSkill : searchSkills) {
                        if (userHardSkill.getName().toUpperCase().equals(searchSkill.toUpperCase())) {
                            coincidedSkills.add(searchSkill);
//                            break;
//                            usersR    esult.add(user);
//                            break;
                        }
                    }
                    if (!coincidedSkills.isEmpty()){
                        result.put(user, coincidedSkills);
                    }
                }
            }
        }


        return result;
    }


}
