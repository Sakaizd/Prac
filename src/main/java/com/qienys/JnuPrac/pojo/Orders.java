package com.qienys.JnuPrac.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//订单
@Entity
public class Orders implements Serializable {
    private static final long serialVersionUID = -7098962332625255485L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long orderId;
    private Long uid;
    private String username;
    private Double totalPrice;
    private boolean payStatus; //1. pay 0.not pay 支付？
    private boolean postStatus;//1. post 0.not post 发货？
    private String telephone;//联系人phone
    private String name;//联系人name
    private String address;//送货地址



    protected Orders(){

    }


    public Orders(long orderId, Long uid, String username, Double totalPrice, boolean payStatus, boolean postStatus, String telephone, String name, String address) {
        this.orderId = orderId;
        this.uid = uid;
        this.username = username;
        this.totalPrice = totalPrice;
        this.payStatus = payStatus;
        this.postStatus = postStatus;
        this.telephone = telephone;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPayStatus() {
        return payStatus;
    }

    public void setPayStatus(boolean payStatus) {
        this.payStatus = payStatus;
    }

    public boolean isPostStatus() {
        return postStatus;
    }

    public void setPostStatus(boolean postStatus) {
        this.postStatus = postStatus;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
