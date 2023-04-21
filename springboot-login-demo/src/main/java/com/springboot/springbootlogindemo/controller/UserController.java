package com.springboot.springbootlogindemo.controller;

import com.springboot.springbootlogindemo.domain.User;
import com.springboot.springbootlogindemo.service.UserService;
import com.springboot.springbootlogindemo.utils.Result;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/*
* UserController 类
*
* Create by Pan-zg on 2023/04/20
* */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String uname,
                                        @RequestParam String password) {
        User user = userService.longinService(uname, password);
        if (user != null) {
            return Result.success(user, "登录成功！");
        }else {
            return Result.error("123", "账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser) {
        User user = userService.registService(newUser);
        if (user != null) {
            return Result.success(user, "注册成功！");
        }else {
            return Result.error("456", "用户已存在！");
        }
    }
}
