package com.willow.service.impl;

import com.willow.entity.Department;
import com.willow.mapper.DepartmentMapper;
import com.willow.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl  implements DepartmentService   {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = {"dept"})
    public Department getDeptById(Integer id) {
        System.out.println("#####getDetpById");
        return departmentMapper.getDeptById(id);
    }

    public int deleteDeptById(Integer id) {
        return departmentMapper.deleteDeptById(id);
    }

    public int insertDept(Department department) {
        return departmentMapper.insertDept(department);
    }

    public int updateDept(Department department) {
        return departmentMapper.updateDept(department);
    }
}
