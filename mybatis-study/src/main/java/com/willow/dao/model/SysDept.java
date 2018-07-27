package com.willow.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 *
 *   @author willow
 *   @date 2018-07-04
 *   @table sys_dept
 */
public class SysDept implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer deptId;

    /** 部门名称 */
    private String name;

    /** 排序 */
    private Integer orderNum;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

    /** 是否删除  -1：已删除  0：正常 */
    private DelFlagEnum delFlag=DelFlagEnum.USABLE;

    private Integer parentId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public DelFlagEnum getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(DelFlagEnum delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public SysDept() {
    }

    public SysDept(String name, Integer orderNum, Date createTime, Date updateTime, Integer parentId) {
        this.name = name;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", name=").append(name);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", parentId=").append(parentId);
        sb.append("]");
        return sb.toString();
    }
}