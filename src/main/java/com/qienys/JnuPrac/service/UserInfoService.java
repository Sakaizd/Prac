package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo findByUid(Long uid);
    void save(UserInfo userInfo);
    List<UserInfo> findAll();
}
