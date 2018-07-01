package com.cvita.services.impl;

import com.cvita.models.*;
import com.cvita.repositories.HardSkillRepository;
import com.cvita.repositories.RoleRepository;
import com.cvita.repositories.UserRepository;
import com.cvita.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HardSkillRepository hardSkillRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
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

    public void saveUser(User user) {
        userRepository.save(user);
    }

//    public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public void saveUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setEnabled(true);
//        Role userRole = roleRepository.findByRole("JS");
////        Role userRole = roleRepository.findByRole("HR");
//        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
//        userRepository.save(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        User user = userRepository.findByEmail(email);
//        if (user != null) {
//            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//            return buildUserForAuthentication(user, authorities);
//        } else {
//            throw new UsernameNotFoundException("username not found");
//        }
//    }
//
//    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//        Set<GrantedAuthority> roles = new HashSet<>();
//        userRoles.forEach((role) -> {
//            roles.add(new SimpleGrantedAuthority(role.getRole()));
//        });
//
//        return new ArrayList<>(roles);
//    }
//
//    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
//    }

//==========================================================================================
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
    public Map<Map<Integer, Integer>, Map<User, List<String>>> hrSearch(List<String> searchSkills) {
        List<User> users = getAllUsers();
        Map<Map<Integer, Integer>, Map<User, List<String>>> result = new HashMap<>();
        for (User user : users) {
            if (user.getAboutUser() != null) {
                List<String> coincidedSkills = new ArrayList<>();
                Map<User, List<String>> preResult = new HashMap<>();
                for (HardSkill userHardSkill : user.getAboutUser().getHardSkills()) {
                    for (String searchSkill : searchSkills) {
                        if (userHardSkill.getName().toUpperCase().equals(searchSkill.toUpperCase())) {
                            coincidedSkills.add(searchSkill);
                        }
                    }
                }
                if (!coincidedSkills.isEmpty()) {
                    preResult.put(user, coincidedSkills);
                    Map<Integer, Integer> numAndPercent = new HashMap<>();
                    numAndPercent.put(result.size() + 1, (coincidedSkills.size() * 100) / searchSkills.size());
                    result.put(numAndPercent, preResult);
                }
            }
        }
        return result;
    }

    @Override
    public HrSearchResult hrSearch2(List<String> searchSkills) {
        HrSearchResult result = new HrSearchResult();
        result.setSearchSkills(searchSkills);
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getAboutUser() != null) {
                List<String> coincidedSkills = new ArrayList<>();

            }
        }
        return result;
    }


}
