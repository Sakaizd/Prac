package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.OrdersRepository;
import com.qienys.JnuPrac.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

}
