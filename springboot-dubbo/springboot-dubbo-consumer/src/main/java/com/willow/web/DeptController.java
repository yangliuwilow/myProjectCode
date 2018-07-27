package com.willow.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.willow.entity.Dept;
import com.willow.service.DeptService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Reference
    private DeptService deptService;

    @RequestMapping("/dept/{id}")
    public Dept getDeptById(@PathVariable Integer id){
        Dept dept=deptService.getDept(id);
        System.out.println("#########"+dept.getDeptName());
        return dept;
    }
}
