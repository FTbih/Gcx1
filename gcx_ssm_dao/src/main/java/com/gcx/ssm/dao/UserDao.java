package com.gcx.ssm.dao;

import com.gcx.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
}
