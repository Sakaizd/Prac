package com.qienys.JnuPrac.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

//订单
@Entity
public class Orders implements Serializable {
    private static final long serialVersionUID = -7098962332625255485L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long uid;
    private Double totalPrice;
    private String telephone;//联系人phone
    private String name;//联系人name
    private String address;//送货地址
    private boolean payStatus; //1. pay 0.not pay 支付？
    private boolean postStatus;//1. post 0.not post 发货？
    private Date createTime;


    protected Orders(){

    }

    public Orders(Long orderId, Long uid, Double totalPrice, String telephone, String name, String address, boolean payStatus, boolean postStatus, Date createTime) {
        this.orderId = orderId;
        this.uid = uid;
        this.totalPrice = totalPrice;
        this.telephone = telephone;
        this.name = name;
        this.address = address;
        this.payStatus = payStatus;
        this.postStatus = postStatus;
        this.createTime = createTime;
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

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

