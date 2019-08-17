package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "memberId", column = "memberId"),
            @Result(property = "product", column = "productId", javaType = ProductDao.class, one=@One(select="com.gcx.ssm.dao.ProductDao.findById")),

    })
    public List<Order> findAll();
}
