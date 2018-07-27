package com.willow.dao.model;

public enum DelFlagEnum {

    DELETE(0,"删除"),USABLE(1,"正常");

    private Integer status;
    private String name;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    DelFlagEnum() {
    }

    DelFlagEnum(Integer status, String name) {
        this.status = status;
        this.name = name;
    }
    public static DelFlagEnum getNameByStatus(Integer status){
        switch (status) {
            case (0):
                 return DELETE;
            case(1):
                return  USABLE;
            default:
                return  USABLE;
        }

    }
}
