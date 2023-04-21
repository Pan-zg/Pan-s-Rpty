package com.springboot.springbootlogindemo.service.serviceImpl;

import com.springboot.springbootlogindemo.domain.User;
import com.springboot.springbootlogindemo.repository.UserDao;
import com.springboot.springbootlogindemo.service.UserService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/*
* 用户注册和登录实现
*
* Create by Pan-zg on 2023/04/20
* */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User longinService(String uname, String password) {
//        return null;
        // 若账号密码都正确则返回登陆的用户对象，有一个错误则返回null
        User user = userDao.findByUnameAndPassword(uname, password);
        // 重要信息置空
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
//        return null;
        // 当新用户注册的用户名已存在
        if (userDao.findByUname(user.getUname()) != null) {
            // 无法注册
            return null;
        }else {
            // 返回创建好的用户对象（带id）
            User newUser = userDao.save(user);
            if (newUser != null) {
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
