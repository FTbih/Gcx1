package com.gcx.ssm.controller;

import com.gcx.ssm.domain.Product;
import com.gcx.ssm.service.ProductService;
import com.gcx.ssm.service.ProductService.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        productService.addProduct(product);
        return "redirect:findAll";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> ps = productService.findAll();
        for (Product p : ps) {
            System.out.println(p.toString());
        }
        modelAndView.addObject("productList", ps);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    //findById是给Order用的，不知道要不要给页面去返回数据，因为页面并没有findById这个功能:不需要

}
