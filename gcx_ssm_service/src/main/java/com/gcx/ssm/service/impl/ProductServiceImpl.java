package com.gcx.ssm.service.impl;

import com.gcx.ssm.dao.ProductDao;
import com.gcx.ssm.domain.Product;
import com.gcx.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //事务相关的注解，忘逑
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

}
