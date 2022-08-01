package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/registration")
    public String getRegisterPage(ModelMap model){
        model.addAttribute("userDto", new UserRegistrationDto());
        return "registration-page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
