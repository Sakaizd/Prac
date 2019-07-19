package com.qienys.JnuPrac.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//商品
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = -1313160282846794932L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String name;
    //private String typeName;//类型名
    //private String brandName;//品牌名
    private Long typeId;
    private Long brandId;
    private String description;//描述
    private Long sold;//卖出
    private Long stock;//库存
    private boolean active;//1:上架 0：下架
    private String url;//图片路径

    protected Product(){

    }

/*    public Product(Double price, String name, String typeName, String brandName, String description, Long sold, String stock, boolean active, String url) {
        this.price = price;
        this.name = name;
        this.typeName = typeName;
        this.brandName = brandName;
        this.description = description;
        this.sold = sold;
        this.stock = stock;
        this.active = active;
        this.url = url;
    }*/

    public Product(Double price, String name, Long typeId, Long brandId, String description, Long sold, Long stock, boolean active, String url) {
        this.price = price;
        this.name = name;
        this.typeId = typeId;
        this.brandId = brandId;
        this.description = description;
        this.sold = sold;
        this.stock = stock;
        this.active = active;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

