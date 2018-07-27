package com.willow.service.impl;


import com.willow.entity.Emp;
import com.willow.mapper.EmpMapper;
import com.willow.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* EmpService实现
* Created by willow on 2018/7/15.
*/
@Service(value = "EmpService")
@Transactional
public class EmpServiceImpl  implements EmpService{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpServiceImpl.class);

    @Autowired
    private EmpMapper empMapper;

    public List<Emp> selectList(Emp emp){
          return  empMapper.selectList(emp);
    }



    public  Emp selectById (Integer id){
          return  empMapper.selectById(id);
    }


    public Integer saveEmp (Emp emp){
         return  empMapper.saveEmp(emp);
    }

    public Integer updateEmp (Emp emp){
        return    empMapper.updateEmp(emp);
    }

    @Override
    public Long deleteByPrimaryKey(Integer id) {
        return null;
    }



}