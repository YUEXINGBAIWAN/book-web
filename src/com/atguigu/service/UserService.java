package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @author shkstart
 * @create 2021-08-24 22:31
 */
public interface UserService {

    /**
     * 注册
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    public  boolean existUsername(String username);
}
