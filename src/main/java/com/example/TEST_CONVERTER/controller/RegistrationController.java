package com.example.TEST_CONVERTER.controller;

import com.example.TEST_CONVERTER.Enum.Role;
import com.example.TEST_CONVERTER.postgres.Entity.User;
import com.example.TEST_CONVERTER.postgres.Repository.UserRepository;
import com.example.TEST_CONVERTER.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {

        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "registration";
        }

        if(!userService.addUser(user)){
            model.addAttribute("userError","User already exists");
            return "registration";
        }

        return "redirect:/login";
    }
}
