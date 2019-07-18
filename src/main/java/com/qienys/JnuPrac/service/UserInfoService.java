package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.UserInfo;

public interface UserInfoService {
    UserInfo findByUid(Long uid);
    void save(UserInfo userInfo);
}
