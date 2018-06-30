package com.cvita.controllers.rest;

import com.cvita.models.AboutUser;
import com.cvita.models.HrSearchResult;
import com.cvita.models.User;
import com.cvita.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<User> saveUser(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/del/{id}")
    public void deleteById(@PathVariable String id){
        userService.removeUserById(id);
    }




    @PostMapping(value = "/addHardSkills/{idUser}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setAboutName(@PathVariable String idUser, @RequestBody List<String> idsHardSkill){
        userService.addHardSkillToAboutUserByUserId(idUser,idsHardSkill);
    }

    @PostMapping(value = "/saveAboutUser/{idUser}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveAboutUser(@RequestBody AboutUser aboutUser,@PathVariable String idUser){
        userService.saveAboutUser(idUser, aboutUser);
    }


    @PostMapping("/search")
    public Map<Map<Integer, Integer>, Map<User, List<String>>> search(@RequestBody List<String> searchSkills){
        return userService.hrSearch(searchSkills);
    }

    @PostMapping("/search2")
    public HrSearchResult search2(@RequestBody List<String> searchSkills){
        return userService.hrSearch2(searchSkills);
    }

}
