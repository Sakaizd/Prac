package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.OrderProductsRepository;
import com.qienys.JnuPrac.service.OrderProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductsServiceImpl implements OrderProductsService {
    @Autowired
    private OrderProductsRepository orderProductsRepository;
}
