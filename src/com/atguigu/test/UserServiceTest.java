package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-08-25 9:27
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {

        userService.registUser(new User(null, "wdf", "123456", "wdf123@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "chp1", "123456", null)));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("root")){
            System.out.println("用户名存在");
        }else{
            System.out.println("可用");
        }
    }
}