package com.gcx.ssm.service;

import com.gcx.ssm.domain.Order;

import java.util.List;

public interface OrderService {
    //查询所有订单信息
    public List<Order> findAll();
}
