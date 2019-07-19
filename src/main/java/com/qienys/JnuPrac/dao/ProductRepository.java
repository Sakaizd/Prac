package com.qienys.JnuPrac.dao;

import com.qienys.JnuPrac.pojo.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
    boolean existsByTypeIdAndBrandIdAndName(Long typeId,Long brandId,String name);
    Product findByTypeIdAndBrandIdAndName(Long typeId,Long brandId,String name);
}
