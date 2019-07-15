package com.qienys.JnuPrac.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer uid;
    private String pswQues;
    private String pswAns;
    private String email;
    private String telephone;
    private String name;
    private String address;
    private String idcard;

    public UserInfo(Integer uid, String pswQues, String pswAns, String email, String telephone, String name, String address, String idcard) {
        this.uid = uid;
        this.pswQues = pswQues;
        this.pswAns = pswAns;
        this.email = email;
        this.telephone = telephone;
        this.name = name;
        this.address = address;
        this.idcard = idcard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPswQues() {
        return pswQues;
    }

    public void setPswQues(String pswQues) {
        this.pswQues = pswQues;
    }

    public String getPswAns() {
        return pswAns;
    }

    public void setPswAns(String pswAns) {
        this.pswAns = pswAns;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
