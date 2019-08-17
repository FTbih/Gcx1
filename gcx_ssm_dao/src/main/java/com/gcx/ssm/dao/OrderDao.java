package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Order;
import com.gcx.ssm.domain.Product;
import com.gcx.ssm.domain.Member;
import org.apache.ibatis.annotations.*;

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
            @Result(property = "product", column = "productId", javaType = Product.class, one=@One(select="com.gcx.ssm.dao.ProductDao.findById")),

    })
    public List<Order> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true, property = "id", column = "id"), //订单编号
            @Result(property = "orderTime", column = "orderTime"),//下单时间
            @Result(property = "orderDesc", column = "orderDesc"),//其他信息
            @Result(property = "peopleCount", column = "peopleCount"),//出游人数

            //路线名称
            //出发城市
            //出发时间
            @Result(property = "product", column = "productId", javaType = Product.class, one=@One(select="com.gcx.ssm.dao.ProductDao.findById")),

            //查询members表
            //联系人信息
            @Result(property = "member", column = "memberId", javaType = Member.class, one=@One(select="com.gcx.ssm.dao.MemberDao.findById")),

            //查询traveller表
            //游客信息
            @Result(property = "travellerList", column = "id", javaType = List.class, many=@Many(select = "com.gcx.ssm.dao.TravellerDao.findById"))
    })
    Order findById(String id);
}
