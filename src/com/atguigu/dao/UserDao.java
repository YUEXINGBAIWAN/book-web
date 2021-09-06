package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author shkstart
 * @create 2021-08-24 20:55
 */
public interface UserDao {

    //根据用户名查询用户信息
    public User queryUserByUsername(String username);

    //保存用户信息
    public int saveuser(User user);

    //根据用户名和密码查询用户信息
    public User queryUsernameAndPassword(String username, String password);
}
