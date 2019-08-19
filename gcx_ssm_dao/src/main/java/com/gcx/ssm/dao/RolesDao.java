package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Permission;
import com.gcx.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*
private String id;
String roleName;
String roleDesc;
List<Permission> permissions;
List<UserInfo> users;
 */
public interface RolesDao {

    @Select("select * from role where id in (select ROLEID from USERS_ROLE where userid=#{id})")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
            many=@Many(select = "com.gcx.ssm.dao.PermissionDao.findById")),
    })
    public List<Role> findById(String id);

    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role (roleName, roleDesc) values (#{roleName}, #{roleDesc})")
    public void save(Role role);

    @Select("select * from permission where id not in (select PERMISSIONID from role_permission where roleid=#{id})")
    List<Permission> findOtherPermission(String id);

    @Insert("insert into role_permission values(#{permissionId}, #{roleId})")
    void addPermissionToRole(@Param("permissionId")String id, @Param("roleId") String roleId);
}
