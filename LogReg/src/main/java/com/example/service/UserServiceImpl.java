package com.example.service;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.model.User;

import java.sql.Date;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = this.findByUserName(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        if (checkExistUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        User user = new User(email, username, fullname, password, null, 5, phone, date);
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
}