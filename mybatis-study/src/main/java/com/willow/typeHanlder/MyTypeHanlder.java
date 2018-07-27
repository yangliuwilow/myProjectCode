package com.willow.typeHanlder;

import com.willow.dao.model.DelFlagEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//实现TypeHandler 接口或者继承 BaseTypeHandler
public class MyTypeHanlder implements TypeHandler<DelFlagEnum> {

    //设置参数
    @Override
    public void setParameter(PreparedStatement ps, int i, DelFlagEnum parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("要保存的状态码："+parameter.getStatus());
        ps.setString(i, parameter.getStatus().toString());
    }

    //按列名，拿到值封装成javabean对象
    @Override
    public DelFlagEnum getResult(ResultSet rs, String columnName) throws SQLException {
        //需要根据从数据库中拿到的枚举的状态码返回一个枚举对象
        int status = rs.getInt(columnName);
        System.out.println("从数据库中获取的状态码："+status);
        DelFlagEnum delFlagEnum = DelFlagEnum.getNameByStatus(status);
        return delFlagEnum;
    }
    //按索引，拿到值封装成javabean对象
    @Override
    public DelFlagEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        int status = rs.getInt(columnIndex);
        System.out.println("从数据库中获取的状态码："+status);
        DelFlagEnum delFlagEnum = DelFlagEnum.getNameByStatus(status);
        return delFlagEnum;
    }
    //存储过程拿到值，封装
    @Override
    public DelFlagEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int status = cs.getInt(columnIndex);
        System.out.println("从数据库中获取的状态码："+status);
        DelFlagEnum delFlagEnum = DelFlagEnum.getNameByStatus(status);
        return delFlagEnum;
    }
}
