// domain中的User.java
package com.springboot.springbootlogindemo.domain;

import jakarta.persistence.*;

/*
* 用户信息（对应数据库中的表）
* Create by Pan-zg on 2023/04/19
* */
@Table(name = "user")
@Entity
public class User {
    // 注意属性名要与数据表中的字段一致
    // 主键自增int(10)对应long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    // 用户名属性varchar对应String
    private String uname;

    // 密码属性varchar对应String
    private String password;

    // 以下代码均为自动生成
    // 方法为：右键Generator - getter and setter，然后选中所有属性，点击OK即可
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
