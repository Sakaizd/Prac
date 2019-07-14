package com.qienys.JnuPrac.service;


import com.qienys.JnuPrac.pojo.User;

public interface UserService {
    User findByUsername(String username);
}
