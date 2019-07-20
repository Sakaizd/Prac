package com.qienys.JnuPrac.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//购物车
@Entity
public class Cart implements Serializable {
    private static final long serialVersionUID = 1974912484119739345L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Long uid;
    private Long count;
    private String productName;
    private Double price;
    //private String typeName;//类型名
    //private String brandName;//品牌名
    private Long brandId;
    private Long typeId;
    private String description;//描述
    private String url;//图片路径


    public Cart(Long productId, Long uid, Long count, String productName, Double price, Long brandId, Long typeId, String description, String url) {
        this.productId = productId;
        this.uid = uid;
        this.count = count;
        this.productName = productName;
        this.price = price;
        this.brandId = brandId;
        this.typeId = typeId;
        this.description = description;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}



