package com.willow.web;

import com.willow.entity.Emp;
import com.willow.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/14.
 */
@Controller
public class EmpController {


    @Autowired
    EmpService empService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Emp> emps = empService.selectList(new Emp()); // 执行远程方法
        emps.forEach(emp -> System.out.println(emp.toString())) ; // 显示调用结果
        model.addAttribute("emps",emps);
        return "emp/list" ;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(Integer step){
        for(int i=0;i<step;i++)
         empService.saveEmp(new Emp(UUID.randomUUID().toString().substring(0,8),"1","12")); // 执行远程方法
        return "ok" ;
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public String get(@PathVariable  Integer id){
        Emp emp= empService.selectById(id);
        return emp.toString() ;
    }
}
