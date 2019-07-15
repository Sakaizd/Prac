package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.UserInfoRepository;
import com.qienys.JnuPrac.dao.UserRepository;
import com.qienys.JnuPrac.pojo.UserInfo;
import com.qienys.JnuPrac.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUid(Long uid) {
        UserInfo userInfo = userInfoRepository.findByUid(uid);
        return userInfo;
    }


}
