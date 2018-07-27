package com.willow.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.willow.entity.Dept;
import com.willow.service.DeptService;
import org.springframework.stereotype.Component;

@Component
@Service  //注册为dubbo bean组件
public class DeptServiceImpl implements DeptService {

    @Override
    public Dept getDept(Integer id) {
        Dept dept=new Dept();
        dept.setDeptName("开发技术部");
        dept.setId(123);
        return dept;
    }
}
