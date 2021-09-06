package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * @author shkstart
 * @create 2021-08-25 9:26
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao= new UserDaoImpl();
    @Override
    public void registUser(User user) {

        userDao.saveuser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return  false;//没有值就是可用用户名
        }
        return true;
    }
}
