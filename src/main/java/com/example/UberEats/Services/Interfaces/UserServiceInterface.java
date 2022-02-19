package com.example.UberEats.Services.Interfaces;

import com.example.UberEats.Models.User;

public interface UserServiceInterface {

    public String createUser(User user);

    public void deleteUser(String userId);

    public void updateUser(User user);

    public User getUser(String userId);

}
