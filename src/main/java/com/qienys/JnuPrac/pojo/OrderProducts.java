package com.qienys.JnuPrac.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//订单中商品
@Entity
public class OrderProducts implements Serializable {
    private static final long serialVersionUID = 4724723806861633406L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;//订单id
    private Long productId;//商品id
    private String name;//商品名
    private Long number;//数量
    private Double price;//价格

    protected OrderProducts(){

    }

    public OrderProducts(Long orderId, Long productId, String name, Long number, Double price) {
        this.orderId = orderId;
        this.productId = productId;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
