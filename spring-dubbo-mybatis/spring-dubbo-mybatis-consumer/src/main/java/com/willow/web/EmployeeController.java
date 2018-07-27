package com.willow.web;


import com.willow.entity.Employee;
import com.willow.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * EmployeeController
 * Created by willow on 20/21.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /**
     * 显示列表
     */
    @RequestMapping
    @ResponseBody
    public String list(Model model, Employee employee) {
        List<Employee> employees = employeeService.selectList(employee);
        model.addAttribute("employees", employees);
        model.addAttribute("employee", employee);
        return "employee/employee_list";
    }

    /**
     * 请求新增页面
     */
    @RequestMapping(value = "/new")
    public String toAdd(Model model) {
        return "employee/employee_edit";
    }


    /**
     * 请求编辑页面
     */
    @RequestMapping(value = "/toEdit/{id}")
    @ResponseBody
    public String toEdit(Model model, @PathVariable Integer id) {
        Employee employee = employeeService.selectById(id);
        model.addAttribute("employee", employee);
        return employee.toString();
    }

    /**
     * 保存页面
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(Model model, Employee employee) {
        if (employee.getId() == null) {    //save
            Employee employee1=new Employee();
            employee1.setEmail("3333432@qq.com");
            employee1.setGender(1);
            employee1.setLastname("杨柳");
            employeeService.saveEmployee(employee1);
            return employee.toString();
        } else {
            employee.setEmail("3333432@qq.com");
            employee.setGender(1);
            employee.setLastname("杨柳123");
            employeeService.updateEmployee(employee);
            return employee.toString();
        }
    }


    /**
     * 删除指定信息
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable Integer id) {
            Integer count = employeeService.deleteEmployee(id);
        return count.toString();
    }

}