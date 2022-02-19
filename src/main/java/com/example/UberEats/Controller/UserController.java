package com.example.UberEats.Controller;

import com.example.UberEats.Models.User;
import com.example.UberEats.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String addUser(final User user) {
        return userService.createUser(user);
    }

    public void deleteUser(final String userId) {
        userService.deleteUser(userId);
    }

    public void updateUser(final User user) {
        userService.updateUser(user);
    }

    public User getUser(final String userId) {
        return userService.getUser(userId);
    }
}
