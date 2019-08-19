package com.gcx.ssm.service;

import com.gcx.ssm.domain.Role;
import com.gcx.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRoleById(String id);

    void addRoleToUser(String userId, String id);
}
