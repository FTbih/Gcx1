package com.gcx.ssm.service;

import com.gcx.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    public void save(Permission permission);

    List<Permission> findAll();
}
