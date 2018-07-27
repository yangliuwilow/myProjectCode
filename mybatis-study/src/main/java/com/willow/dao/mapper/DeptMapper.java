package com.willow.dao.mapper;

import com.willow.dao.model.SysDept;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface DeptMapper {

    SysDept selectById(Integer deptId);

    int saveSysDept(SysDept sysDept);

    int saveDeptBatch(List<SysDept> sysDept);
}
