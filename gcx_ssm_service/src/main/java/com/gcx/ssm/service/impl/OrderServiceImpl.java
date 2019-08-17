package com.gcx.ssm.service.impl;

import com.gcx.ssm.dao.OrderDao;
import com.gcx.ssm.domain.Order;
import com.gcx.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }
}
