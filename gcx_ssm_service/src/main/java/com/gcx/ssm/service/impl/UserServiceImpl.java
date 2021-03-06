package com.gcx.ssm.service.impl;

import com.gcx.ssm.dao.UserDao;
import com.gcx.ssm.domain.Role;
import com.gcx.ssm.domain.UserInfo;
import com.gcx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //调用dao查询用户信息
        UserInfo userInfo = userDao.findByUsername(s);
        //由于需要返回一个UserDetails对象，所以需要新建一个User对象（框架提供的）,将账号密码等参数传入，然后返回
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()==1?true:false,true, true, true, getAuthority(userInfo));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(UserInfo userInfo){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        List<Role> roles = userInfo.getRoles();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        String encode = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoleById(String id) {
        return userDao.findOtherRoleById(id);
    }

    @Override
    public void addRoleToUser(String userId, String id) {
        userDao.addRoleToUser(userId, id);
    }
}
