package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
