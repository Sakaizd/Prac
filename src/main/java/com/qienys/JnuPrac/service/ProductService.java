package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Iterable<Product> findAllById(Iterable<Long> IDs);
}
