package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Role;
import com.gcx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
String id;
String username;
String email;
String password;
String phoneNum;
int status;
String statusStr;
List<Role> roles;
 */
public interface UserDao {
    //根据用户名查询用户信息
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many=@Many(select="com.gcx.ssm.dao.RolesDao.findById"))
    })
    public UserInfo findByUsername(String username);

    //查询所有用户信息
    @Select("select * from users")
    public List<UserInfo> findAll();

    //插入用户信息
    @Insert("insert into users (username, password, email, phonenum, status) values (#{username}, #{password}, #{email}, #{phoneNum}, #{status})")
    void save(UserInfo userInfo);

    //根据ID查询用户的详细信息，包括角色以及角色具有的权限
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many=@Many(select="com.gcx.ssm.dao.RolesDao.findById"))

    })
    UserInfo findById(String id);


    @Select("select * from ROLE where id not in(select roleid from USERS_ROLE where userid=#{id})")
    List<Role> findOtherRoleById(String id);

    @Insert("insert into USERS_ROLE values(#{userId}, #{id})")
    void addRoleToUser(@Param("userId") String userId, @Param("id") String id);
}
