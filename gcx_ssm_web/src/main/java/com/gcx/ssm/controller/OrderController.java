package com.gcx.ssm.controller;


import com.gcx.ssm.domain.Order;
import com.gcx.ssm.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /*
    分页工具
    1、导入jar包
    2、配置文件配置
    3、在查询语句前加上
     */

//    @RequestMapping("/findAll")
//    public ModelAndView findAll(){
//
//        List<Order> orderList = orderService.findAll();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("ordersList", orderList);
//        modelAndView.setViewName("orders-list");
//        return modelAndView;
//    }

    @RequestMapping("/findAllByPage")
    public ModelAndView findAllByPage(@RequestParam(name="currentPage", required = true, defaultValue = "1")Integer currentPage, @RequestParam(name="pageSize", required = true, defaultValue = "3")Integer pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Order> orderList = orderService.findAll();
        PageInfo pageInfo = new PageInfo(orderList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

}
