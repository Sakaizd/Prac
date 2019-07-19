package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders,Long> {
    List<Orders> findAllByUid(Long uid);
    boolean existsByOrderId(Long orderId);
    Orders findByOrderId(Long orderID);
}
