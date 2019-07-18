package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.OrdersRepository;
import com.qienys.JnuPrac.pojo.Cart;
import com.qienys.JnuPrac.pojo.Orders;
import com.qienys.JnuPrac.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void save(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public List<Orders> findAllByUid(Long uid) {
        Iterable<Orders> list = ordersRepository.findAllByUid(uid);
        return  (List<Orders>) list;
    }

    @Override
    public List<Orders> findAll() {
        Iterable<Orders> list = ordersRepository.findAll();
        return  (List<Orders>) list;
    }
}
