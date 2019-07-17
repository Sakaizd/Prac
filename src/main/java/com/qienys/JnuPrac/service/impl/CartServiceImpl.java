package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.CartRepository;
import com.qienys.JnuPrac.pojo.Cart;
import com.qienys.JnuPrac.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAllByUid(Long uid) {
        Iterable<Cart> list = cartRepository.findAllByUid(uid);
        return  (List<Cart>) list;
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Boolean existsByUidAndProductId(Long uid, Long productId) {
        return cartRepository.existsByUidAndProductId(uid,productId);
    }

    @Override
    public Cart findByUidAndAndProductId(Long uid, Long productId) {
        Cart cart = cartRepository.findByUidAndAndProductId(uid,productId);
        return cart;
    }
}
