package com.willow.main;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
public class family {

    List<List<Object>> arrObj=new LinkedList<List<Object>>();


    public List<List<Object>> getArrObj() {
        return arrObj;
    }

    public void setArrObj(List<List<Object>> arrObj) {
        this.arrObj = arrObj;
    }

    public void putPeople(List<Object> people) {
        arrObj.add(people);
    }
}
