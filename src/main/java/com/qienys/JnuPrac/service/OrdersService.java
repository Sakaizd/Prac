package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Orders;

import java.util.List;

public interface OrdersService {
    void save(Orders orders);
    List<Orders> findAllByUid(Long uid);
    List<Orders> findAll();
}
