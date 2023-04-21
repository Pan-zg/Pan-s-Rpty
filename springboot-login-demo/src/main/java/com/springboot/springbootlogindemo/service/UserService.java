package com.springboot.springbootlogindemo.service;

import com.springboot.springbootlogindemo.domain.User;

/*
* UserService 接口
*
* Create by Pan-zg on 2023/04/20
* */
public interface UserService {
    /*
    * 登录业务逻辑
    * @param uname 账户名
    * @param password 密码
    * @return
    * */
    User longinService(String uname, String password);

    /*
    * 注册业务逻辑
    * @param User
    * @return
    * */
    User registService(User user);
}
