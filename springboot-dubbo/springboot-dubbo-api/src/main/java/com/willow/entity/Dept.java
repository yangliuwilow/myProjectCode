package com.willow.entity;


import java.io.Serializable;

public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  deptName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
