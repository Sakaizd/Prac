package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    void save (Product product);
    boolean existsByTypeIdAndBrandIdAndName(Long typeId,Long brandId,String name);
    Product findByTypeIdAndBrandIdAndName(Long typeId,Long brandId,String name);
}
