package com.willow.mapper;

import com.willow.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* EmployeeMapper接口
* Created by willow on 2018/7/22.
*/
@Mapper
public interface EmployeeMapper {

        /**
         * 查询
         * @param employee
         * @return  List<Employee>
         */
        public List<Employee> selectList(Employee employee);
        /**
         * 根据ID查询
         * @param id
         * @return  Employee
         */
        public Employee  selectById(Integer id);
        /**
         * 保存
         * @param employee
         * @return Employee
         */
        public Integer saveEmployee(Employee employee);
        /**
        * 根据ID修改
        * @param employee
        * @return Employee
        */
        public Integer updateEmployee(Employee employee);
        /**
         * 根据ID删除
         * @param id
         * @return Long
         */
        public Integer deleteById(Integer id);
}