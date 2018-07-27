package com.willow;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.willow.dao.mapper.DeptMapper;
import com.willow.dao.model.DelFlagEnum;
import com.willow.dao.model.SysDept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory ;
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void mybatisXml() {
        SqlSession session = getSqlSessionFactory().openSession();
        try {
            SysDept dept=new SysDept();dept.setDeptId(1);
            SysDept sysDept = (SysDept) session.selectOne("com.willow.dao.mapper.DeptMapper.selectOne", dept);
            System.out.println(sysDept.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Test
    public void mybatisMapper() {
        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            Page<Object> page = PageHelper.startPage(1, 5);
            DeptMapper deptMapper = (DeptMapper) openSession.getMapper(DeptMapper.class);
            System.out.println("##########" + deptMapper);
            SysDept d=deptMapper.selectById(1);
            System.out.println("########当前页"+page.getPageNum());
            System.out.println("########总页码"+page.getPages());
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
    }



    @Test
    public void mybatisBatch() {
        SqlSession session = getSqlSessionFactory().openSession();
        try {
            DeptMapper deptMapper = (DeptMapper) session.getMapper(DeptMapper.class);
            long start =System.currentTimeMillis();
            for (int i = 0; i <10000 ; i++) {
                SysDept dept=new SysDept(UUID.randomUUID().toString().substring(1,6), 1, new Date(),  new Date(), 1);
                deptMapper.saveSysDept(dept);
            }
            long end =System.currentTimeMillis();
            System.out.println("耗时:"+(end-start));
            //ExecutorType.BATCH 批量耗时耗时:2134
            //单条操作耗时 耗时:8584
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
    }
    @Test
    public void saveDeptBatchOne() {
        SqlSession session = getSqlSessionFactory().openSession();
        try {
            DeptMapper deptMapper = (DeptMapper) session.getMapper(DeptMapper.class);
            long start =System.currentTimeMillis();
            List<SysDept> deptList=new ArrayList<SysDept>();
            for (int i = 0; i <100000 ; i++) {
                SysDept dept=new SysDept(UUID.randomUUID().toString().substring(1,6), 1, new Date(),  new Date(), 1);
                deptList.add(dept);
                if(i%500==0){
                    deptMapper.saveDeptBatch(deptList);
                    deptList.clear();
                }
            }
            deptMapper.saveDeptBatch(deptList);
            long end =System.currentTimeMillis();
            System.out.println("耗时:"+(end-start));
            //非BATCH批量耗时 耗时:938
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
    }

    @Test
    public void saveDeptBatchTwo() {
        SqlSession session = getSqlSessionFactory().openSession(ExecutorType.BATCH);
        try {
            DeptMapper deptMapper = (DeptMapper) session.getMapper(DeptMapper.class);
            long start =System.currentTimeMillis();
            List<SysDept> deptList=new ArrayList<SysDept>();
            for (int i = 0; i <100000*100; i++) {
                SysDept dept=new SysDept(UUID.randomUUID().toString().substring(1,6), 1, new Date(),  new Date(), 1);
                deptList.add(dept);
                 if(i%2000==0){
                     deptMapper.saveDeptBatch(deptList);
                    deptList.clear();
                }
            }
            deptMapper.saveDeptBatch(deptList);
            long end =System.currentTimeMillis();
            System.out.println("耗时:"+(end-start));
            //BATCH批量耗时 耗时:822
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
    }

    @Test
    public void saveTypeHadler() {
        SqlSession session = getSqlSessionFactory().openSession();
        try {
            DeptMapper deptMapper = (DeptMapper) session.getMapper(DeptMapper.class);
                SysDept dept=new SysDept(UUID.randomUUID().toString().substring(1,6), 1, new Date(),  new Date(), 1);
            //deptMapper.saveSysDept(dept);
            SysDept de= deptMapper.selectById(410015);
            System.out.println(de.getDelFlag().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
        }
    }
}
