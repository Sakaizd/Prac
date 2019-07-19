package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.ProductRepository;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        Iterable<Product> list = productRepository.findAll();
        return (List<Product>) list;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product=productRepository.findById(id);
        return product.get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

}
