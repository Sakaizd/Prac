package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
    UserInfo findByUid (Long uid);
    boolean existsByUid(Long uid);
}
