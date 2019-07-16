package com.qienys.JnuPrac.service;


import com.qienys.JnuPrac.pojo.User;

public interface UserService {
    User findByUserName(String username);
    void save (User user);
}