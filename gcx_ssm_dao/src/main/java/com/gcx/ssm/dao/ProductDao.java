package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductDao {
    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll();


    //添加产品信息
    /*
    问题1：数据库自动生成的ID怎么插入，写个null让他自己生成？直接回避id这个字段
    问题2：是不是直接使用#{字段名}即可，是
    问题3：日期的自动类型转换，
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void addProduct(Product product);

    //根据id查询product
    @Select("select * from product where id=#{id}")
    public Product findById(String id);
}
