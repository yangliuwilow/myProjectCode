

package com.willow.core.system.model;

import java.io.Serializable;

public class ItcastUser implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id#OS */
	private Long id;
	/** 名称#OS */
	private String name;
	/** 登录名#OS */
	private String loginname;
	/** 密码#OS */
	private String password;
	/** 性别#OS */
	private String gender;
	/** 手机#OS */
	private String phonenumber;
	/** 描述#OS */
	private String description;
	/** 邮件#OS */
	private String email;
	/** 部门#OS */
	private Long departmentid;
	/** 创建时间#OS */
	private java.util.Date createDate;
	/** 修改时间#OS */
	private java.util.Date modifyDate;

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long value) {
		this.id = value;
	}
	
	
	
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	
	
	
	
	public String getLoginname() {
		return this.loginname;
	}
	
	public void setLoginname(String value) {
		this.loginname = value;
	}
	
	
	
	
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	
	
	
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String value) {
		this.gender = value;
	}
	
	
	
	
	
	public String getPhonenumber() {
		return this.phonenumber;
	}
	
	public void setPhonenumber(String value) {
		this.phonenumber = value;
	}
	
	
	
	
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	
	
	
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	
	
	
	
	public Long getDepartmentid() {
		return this.departmentid;
	}
	
	public void setDepartmentid(Long value) {
		this.departmentid = value;
	}
	
	
	
	
	
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}
	
	
	
	
	
	public java.util.Date getModifyDate() {
		return this.modifyDate;
	}
	
	public void setModifyDate(java.util.Date value) {
		this.modifyDate = value;
	}
	
	
	
	
	

}

