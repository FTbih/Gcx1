package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface PermissionDao {
    @Select("select * from PERMISSION where id in (select PERMISSIONID from ROLE_PERMISSION where roleid=#{id})")
    public List<Permission> findById(String id);

    @Insert("insert into PERMISSION (permissionName, url) values (#{permissionName}, #{url})")
    void save(Permission permission);

    @Select("select * from PERMISSION")
    List<Permission> findAll();
}
