package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.UserRepository;
import com.qienys.JnuPrac.pojo.User;
import com.qienys.JnuPrac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String username ) {
        User user = userRepository.findByUserName(username);
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByUserName (String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public List<User> findAll() {
        Iterable<User> list = userRepository.findAll();
        return  (List<User>) list;
    }

}
