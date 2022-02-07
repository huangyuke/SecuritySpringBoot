package com.baosight.security.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @RequestMapping(value = "login-success", produces = {"text/plain;charset=UTF-8"})
    public String login() {
        return "登录成功";
    }

    @GetMapping(value = "r/r1", produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session) {
        return "访问资源r1";
    }

    @GetMapping(value = "r/r2", produces = {"text/plain;charset=utf-8"})
    public String r2(HttpSession session) {
        return "访问资源r2";
    }
}
