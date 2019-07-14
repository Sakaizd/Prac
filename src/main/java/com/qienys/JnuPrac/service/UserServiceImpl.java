package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.dao.UserRepository;
import com.qienys.JnuPrac.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User findByUsername(String username ) {
        User user = userRepository.findByUsername(username);
        return user;
    }
}
