package com.willow.entity;

import java.io.Serializable;

/** 
 *
 *   @author willow
 *   @date 2018-07-15
 *   @table emp
 */
public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String empName;

    private String empNo;

    private String empAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpAge() {
        return empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public Emp() {
    }

    public Emp(String empName, String empNo, String empAge) {
        this.empName = empName;
        this.empNo = empNo;
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", empName=").append(empName);
        sb.append(", empNo=").append(empNo);
        sb.append(", empAge=").append(empAge);
        sb.append("]");
        return sb.toString();
    }
}