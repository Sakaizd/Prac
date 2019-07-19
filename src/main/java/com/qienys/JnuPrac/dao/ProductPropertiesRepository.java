package com.qienys.JnuPrac.dao;


import com.qienys.JnuPrac.pojo.ProductProperties;
import org.springframework.data.repository.CrudRepository;


public interface ProductPropertiesRepository extends CrudRepository<ProductProperties,Long> {
    ProductProperties findByBrandIdAndAndTypeId(Long brandId,Long typeId);
}
