package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.OrderProducts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductsRepository extends CrudRepository<OrderProducts,Long> {
    List<OrderProducts> findAllByOrderId(Long orderId);

}
