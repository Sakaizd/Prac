package com.qienys.JnuPrac.service.impl;

import com.qienys.JnuPrac.dao.ProductPropertiesRepository;
import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.pojo.ProductProperties;
import com.qienys.JnuPrac.service.ProductPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPropertiesServiceImpl implements ProductPropertiesService {
    @Autowired
    private ProductPropertiesRepository productPropertiesRepository;
    @Override
    public ProductProperties findByBrandIdAndAndTypeId(Long brandId, Long typeId) {
        return productPropertiesRepository.findByBrandIdAndAndTypeId(brandId,typeId);
    }


}
