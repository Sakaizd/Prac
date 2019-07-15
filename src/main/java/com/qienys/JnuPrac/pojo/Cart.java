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
    private Long number;

    protected Cart(){

    }
    public Cart(Long productId, Long uid, Long number) {
        this.productId = productId;
        this.uid = uid;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getproductId() {
        return productId;
    }

    public void setproductId(Long productid) {
        this.productId = productid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
