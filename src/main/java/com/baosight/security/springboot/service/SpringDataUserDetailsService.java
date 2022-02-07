package com.baosight.security.springboot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //将来连接数据库根据账号查询用户信息
        //暂时采用模拟方式
        //登录账号
        System.out.println("username=" + username);
        //模拟
        UserDetails userDetails = User.withUsername("zhangsan").password("123").authorities("p1").build();
        return userDetails;
    }
}
