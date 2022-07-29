package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.dto.UserRegistrationDto;
import com.illiapinchuk.carrentalsystem.model.RoleName;
import com.illiapinchuk.carrentalsystem.model.User;
import com.illiapinchuk.carrentalsystem.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@ModelAttribute UserRegistrationDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserInfo(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PutMapping(value="/{userId}")
    public void updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
    }

    @PutMapping("/{userId}/addRole")
    public void addUserRole(@PathVariable Long userId, @RequestParam(name = "role") RoleName role) {
        userService.addRoleToUser(userId, role);
    }
}
