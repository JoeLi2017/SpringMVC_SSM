package com.happy.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lirongbo on 2017/7/6.
 */
public class User implements Serializable{

    private String id;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String password;
    private String passwordSalt;
    private Date createDate;
    private Date updateDate;
    private int tombstone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getTombstone() {
        return tombstone;
    }

    public void setTombstone(int tombstone) {
        this.tombstone = tombstone;
    }
}
