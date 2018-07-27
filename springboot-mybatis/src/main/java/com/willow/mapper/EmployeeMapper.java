package com.willow.mapper;

import com.willow.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public Integer insertEmp(Employee employee) ;
}
