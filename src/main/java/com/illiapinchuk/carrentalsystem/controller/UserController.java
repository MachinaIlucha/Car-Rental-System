package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.dto.UserRegistrationDto;
import com.illiapinchuk.carrentalsystem.model.RoleName;
import com.illiapinchuk.carrentalsystem.model.User;
import com.illiapinchuk.carrentalsystem.service.interfaces.UserService;
import com.illiapinchuk.carrentalsystem.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") UserRegistrationDto userDto){
        userService.addUser(userDto);
        return "redirect:/login";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @Secured("ROLE_CUSTOMER")
    @GetMapping("/my-profile")
    public String getUserProfile(ModelMap model){
        User user = SecurityUtil.getAuthorizedUser();
        model.addAttribute("user", user);
        return "profile";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{userId}")
    public String getUserInfo(ModelMap model, @PathVariable Long userId){
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "profile";
    }

    @Secured("ROLE_CUSTOMER")
    @PutMapping(value="/{userId}")
    public void updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{userId}/addRole")
    public void addUserRole(@PathVariable Long userId, @RequestParam(name = "role") RoleName role) {
        userService.addRoleToUser(userId, role);
    }
}
