package com.qienys.JnuPrac.service;


import com.qienys.JnuPrac.pojo.User;

import java.util.List;

public interface UserService {
    User findByUserName(String username);
    User findById(Long id);
    void save (User user);
    boolean existsById(Long id);
    boolean existsByUserName (String username);
    List<User> findAll();
}