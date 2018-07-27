package com.willow.service;

import com.willow.entity.Department;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    public Department getDeptById(Integer id);

    public int deleteDeptById(Integer id);

    public int insertDept(Department department);

    public int updateDept(Department department);
}
