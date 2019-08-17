package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolesDao {

    @Select("select * from role where id in (select ROLEID from USERS_ROLE where userid=#{id})")
    public List<Role> findById(String id);
}
