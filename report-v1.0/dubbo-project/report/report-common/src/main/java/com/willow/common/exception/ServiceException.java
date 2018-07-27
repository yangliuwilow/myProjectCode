package com.willow.common.exception;

/**
 * Created by Administrator on 2015/1/9.
 */

import java.util.Arrays;

/**
 * @author xiexh
 * 服务异常
 * 11:52:24
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    private String[] param=null;

    private String code;
    private String type; //0-PC,1-Mobile


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ServiceException(){
        super();
    }
    public ServiceException(String code){
        this.code=code;
    }
    public ServiceException(String code,String message){
        super(message);
        this.code=code;
    }
    public ServiceException(String type,String code,String message){
        super(message);
        this.code=code;
        this.type=type;
    }

    public ServiceException(String code,String[] param){
        this.code=code;
        this.param=param;

    }
    public String getEventID(){
        return code;
    }
    public String getType(){
        return type;
    }

    public String[] getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "param=" + Arrays.toString(param) +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
