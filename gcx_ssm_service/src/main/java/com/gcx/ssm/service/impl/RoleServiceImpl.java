package com.gcx.ssm.service.impl;

import com.gcx.ssm.dao.RolesDao;
import com.gcx.ssm.domain.Role;
import com.gcx.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesDao rolesDao;

    @Override
    public List<Role> findAll() {
        return rolesDao.findAll();
    }

    @Override
    public void save(Role role) {
        rolesDao.save(role);
    }
}
