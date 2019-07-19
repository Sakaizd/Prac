package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.Cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends CrudRepository<Cart,Long> {
    Iterable<Cart> findAllByUid(Long uid);
    Boolean existsByUidAndProductId(Long uid,Long productId);
    Cart findByUidAndAndProductId(Long uid,Long productId);

    @Transactional
    void deleteByUidAndProductId(Long uid,Long productId);
}
