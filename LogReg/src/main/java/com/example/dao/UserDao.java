package com.example.dao;

import com.example.model.User;

public interface UserDao {
    User findByUserName(String username);
    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}