package com.irctc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.dao.UserDao;
import com.irctc.entity.User;
import com.irctc.exception.InvalidPasswordException;
import com.irctc.exception.UserNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User login(String email, String password) {

        User user = userDao.findByEmail(email);

        if (user == null)
            throw new UserNotFoundException("User Not Found");

        if (!user.getPassword().equals(password))
            throw new InvalidPasswordException("Invalid Password");

        return user;
    }

    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(Integer userId) {

        User user = userDao.getUserById(userId);

        if (user == null)
            throw new UserNotFoundException("User Not Found");

        return user;
    }

    public User updateUser(Integer userId, User user) {

        User existingUser = getUserById(userId);

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());

        return userDao.updateUser(existingUser);
    }

    public String deleteUser(Integer userId) {

        getUserById(userId);

        userDao.deleteUser(userId);

        return "User Deleted Successfully";
    }
}