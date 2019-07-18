package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.OrderProducts;

import java.util.List;

public interface OrderProductsService  {
    void save (OrderProducts orderProducts);
    List<OrderProducts> findAllByOrderId(Long orderId);
}
