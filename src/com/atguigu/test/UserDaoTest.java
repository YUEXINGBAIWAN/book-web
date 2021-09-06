package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-08-24 21:27
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {


        System.out.println(userDao.queryUserByUsername("admin"));

    }

    @Test
    public void saveuser() {
        System.out.println(userDao.saveuser(new User(null, "root", "123456", "root@1686.com")));
    }

    @Test
    public void queryUsernameAndPassword() {

        System.out.println(userDao.queryUsernameAndPassword("admin", "123456"));
    }

}