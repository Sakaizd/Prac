package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Cart;

import java.util.List;

public interface CartService {
    List<Cart>findAllByUid(Long uid);
    void save (Cart cart);
    Boolean existsByUidAndProductId(Long uid,Long productId);
    Cart findByUidAndAndProductId(Long uid,Long productId);
    void deleteByUidAndProductId(Long uid,Long productId);
}
