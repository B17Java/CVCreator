package com.cvita.controllers;

import com.cvita.models.User;
import com.cvita.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping(value = "/aboutname/{iduser}/{idhardskill}")
    public void setAboutName(@PathVariable String iduser,
                             @PathVariable String idhardskill){
        userService.addNameToAboutUser(iduser,idhardskill);
    }

}
