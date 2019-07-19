package com.qienys.JnuPrac.service;

import com.qienys.JnuPrac.pojo.Product;
import com.qienys.JnuPrac.pojo.ProductProperties;

import java.util.List;

public interface ProductPropertiesService {
    ProductProperties findByBrandIdAndAndTypeId(Long brandId, Long typeId);


}
