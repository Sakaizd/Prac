package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {

}
