package com.gcx.ssm.service;

import com.gcx.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    //查询所有商品信息
    public List<Product> findAll();

    //添加商品信息
    public void addProduct(Product product);

}
