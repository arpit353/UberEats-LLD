package com.example.UberEats.Services;

import com.example.UberEats.Models.User;
import com.example.UberEats.Services.Interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import static com.example.UberEats.Datastore.UserData.userData;

@Service
public class UserService implements UserServiceInterface {

    @Override
    public String createUser(User user) {
        userData.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public void deleteUser(String id) {
        userData.remove(id);
    }

    @Override
    public void updateUser(User user) {
        userData.put(user.getId(), user);
    }

    @Override
    public User getUser(String userId) {
        return userData.get(userId);
    }
}
