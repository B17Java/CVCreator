/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvita.controllers;

import com.cvita.models.User;
//import com.cvita.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author didin
 */
@Controller
public class LoginController {

//    @Autowired
//    private CustomUserDetailsService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index() {
//        System.out.println("index");
//        return "/";
//    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByEmail(user.getEmail());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the username provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("signup");
//        } else {
//            userService.saveUser(user, user.getRoleFromForm());
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new User());
//            modelAndView.setViewName("login");
//        }
//        return modelAndView;
//    }

//    @RequestMapping(value = "/user/user_profile", method = RequestMethod.GET)
//    public ModelAndView js() {
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        System.out.println(auth);
//
//        modelAndView.addObject("currentUser", user);
//        modelAndView.addObject("fullName", "Welcome " + user.getFullname());
//        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("user/user_profile");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/hr/hr_profile", method = RequestMethod.GET)
//    public ModelAndView hr() {
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        System.out.println(auth);
//        modelAndView.addObject("currentUser", user);
//        modelAndView.addObject("fullName", "Welcome " + user.getFullname());
//        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("hr/hr_profile");
//        return modelAndView;
//    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = {"/user",}, method = RequestMethod.GET)
    public String homeuser() {
        return "homeuser";
    }

    @RequestMapping(value = {"/indexhr",}, method = RequestMethod.GET)
    public String indexhr() {
        return "indexHR.html";
    }

    @RequestMapping(value = {"/indexUser",}, method = RequestMethod.GET)
    public String indexUser() {
        return "indexUser.html";
    }


    @RequestMapping(value = {"/indexHRauth",}, method = RequestMethod.GET)
    public String indexHRauth() {
        return "indexHRauth.html";
    }

    @RequestMapping(value = {"/indexHRauthSearch",}, method = RequestMethod.GET)
    public String indexHRauths() {
        return "indexHRauthSearch.html";
    }

    @RequestMapping(value = {"/hrSearchResult",}, method = RequestMethod.GET)
    public String hrSearchResult() {
        return "hrSearchResult.html";
    }


    @GetMapping("/403")
    public String error403() {
        return "/403";
    }

    @GetMapping("/indexUser.html")
    public String errodfghr403() {
        return "/user/indexUser.html";
    }

    @GetMapping("/grad")
    public String grad() {
        return "/grad.html";
    }

    @GetMapping("/indexHR.html")
    public String errod5252fghr403() {
        return "/hr/indexHR.html";
    }

}
