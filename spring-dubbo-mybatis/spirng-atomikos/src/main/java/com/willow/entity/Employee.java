package com.willow.entity;

import java.io.Serializable;

/** 
 *
 *   @author willow
 *   @date 2018-07-21
 *   @table employee
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;

    /** 名称 */
    private String lastname;

    /** 电子邮件 */
    private String email;

    private Integer gender;

    private Integer dId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", lastname=").append(lastname);
        sb.append(", email=").append(email);
        sb.append(", gender=").append(gender);
        sb.append(", dId=").append(dId);
        sb.append("]");
        return sb.toString();
    }
}