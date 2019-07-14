package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

}
