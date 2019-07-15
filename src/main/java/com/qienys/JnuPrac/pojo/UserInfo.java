package com.qienys.JnuPrac.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//用户信息
@Entity
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -3154423115116868855L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long uid;//用户id
    private String pswQues;//密码问题
    private String pswAns;//问题答案
    private String email;//邮箱
    private String telephone;//电话
    private String name;//姓名
    private String address;//地址
    private String idCard;//身份证

    protected UserInfo(){

    }

    public UserInfo(Long uid, String pswQues, String pswAns, String email, String telephone, String name, String address, String idcard) {
        this.uid = uid;
        this.pswQues = pswQues;
        this.pswAns = pswAns;
        this.email = email;
        this.telephone = telephone;
        this.name = name;
        this.address = address;
        this.idCard = idcard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
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
        return idCard;
    }

    public void setIdcard(String idcard) {
        this.idCard = idcard;
    }
}
