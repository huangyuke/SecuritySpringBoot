package com.baosight.security.springboot.service;

import com.baosight.security.springboot.dao.UserDao;
import com.baosight.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //连接数据库根据账号查询用户信息
        UserDto user = userDao.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        //模拟
        UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword()).authorities("p1").build();
        return userDetails;
    }
}
