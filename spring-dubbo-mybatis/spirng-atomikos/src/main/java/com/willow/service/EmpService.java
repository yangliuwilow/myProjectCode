package com.willow.service;

import com.willow.entity.Emp;

import java.util.List;

/**
* EmpService接口
* Created by willow on 2018/7/15.
*/
public interface EmpService {

        /**
         * 查询
         * @param emp
         * @return  List<Emp>
         */
        public List<Emp> selectList(Emp emp);
        /**
         * 根据ID查询
         * @param id
         * @return  Emp
         */
        public Emp  selectById(Integer id);
        /**
         * 保存
         * @param emp
         * @return Emp
         */
        public Integer saveEmp(Emp emp);
        /**
        * 根据ID修改
        * @param emp
        * @return Emp
        */
        public Integer updateEmp(Emp emp);
        /**
         * 根据ID删除
         * @param id
         * @return Long
         */
        public Long deleteByPrimaryKey(Integer id);
}