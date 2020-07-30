package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.UserInfoRepository;
import com.qienys.JnuPrac.dao.UserRepository;
import com.qienys.JnuPrac.pojo.UserInfo;
import com.qienys.JnuPrac.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUid(Long uid) {
        UserInfo userInfo = userInfoRepository.findByUid(uid);
        return userInfo;
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        Iterable<UserInfo> list = userInfoRepository.findAll();
        return  (List<UserInfo>) list;
    }

    @Override
    public boolean existsByUid(Long uid) {
        return userInfoRepository.existsByUid(uid);
    }


}
