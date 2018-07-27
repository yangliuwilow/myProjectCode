package com.willow.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.willow.mapper.EmployeeMapper;
import com.willow.entity.Employee;
import com.willow.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
* EmployeeService实现
* Created by willow on 2018/7/22.
*/
@Service(value = "EmployeeService")
@Transactional
public class EmployeeServiceImpl  implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> selectList(Employee employee){
          return  employeeMapper.selectList(employee);
    }

    public  Employee selectById (Integer id){
          return  employeeMapper.selectById(id);
    }

    public Integer saveEmployee (Employee employee){
         return  employeeMapper.saveEmployee(employee);
    }

    public Integer updateEmployee (Employee employee){
        return    employeeMapper.updateEmployee(employee);
    }

    public Integer deleteEmployee (Integer id){
        return  employeeMapper.deleteById(id);
    }

}