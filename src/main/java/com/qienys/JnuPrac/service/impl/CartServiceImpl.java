package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.CartRepository;
import com.qienys.JnuPrac.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
}
