package com.springboot.springbootlogindemo.repository;

import com.springboot.springbootlogindemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* 访问数据库的方法（通过用户名和用户名+密码寻找用户）
* Create by Pan-zg on 2023/04/19
* */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUname(String uname);     // 通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名
    User findByUnameAndPassword(String uname, String password);     // 通过用户名和密码查找用户
}

//以上给出了两种查找用户的方法，实际上还有其他的自定义方法，如：
//@Query(value = "select * from user where uname LIKE ?1 OR email LIKE ?2 OR lastdid LIKE ?3 OR uid LIKE ?4",nativeQuery = true)
//Page<User> findUserswithoutgender(
//        String uname,
//        String email,
//        String lastdid,
//        String uid,
//        Pageable request
//);