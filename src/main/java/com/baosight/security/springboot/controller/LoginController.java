package com.baosight.security.springboot.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @RequestMapping(value = "login-success", produces = {"text/plain;charset=UTF-8"})
    public String login() {
        return getUsername() + " 登录成功";
    }

    @GetMapping(value = "r/r1", produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session) {
        return getUsername() + " 访问资源r1";
    }

    @GetMapping(value = "r/r2", produces = {"text/plain;charset=utf-8"})
    public String r2(HttpSession session) {
        return getUsername() + " 访问资源r2";
    }

    private String getUsername() {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "匿名";
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}
