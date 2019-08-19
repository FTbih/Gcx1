package com.gcx.ssm.service;

import com.gcx.ssm.domain.Permission;
import com.gcx.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    void save(Role role);

    List<Permission> findOtherPermission(String id);

    void addPermissionToRole(String roleId, String id);
}
