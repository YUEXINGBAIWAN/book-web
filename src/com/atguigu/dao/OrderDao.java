package com.atguigu.dao;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-08-30 14:16
 */
public interface OrderDao {
    public int saveOrder(Order order);

    Integer queryForPageTotalCount();

    public List<Order> queryOrders(int begin, int pageSize);

    int sendOrder(String orderId, int status);

    List<Order> queryOrdersByUserId(int userId);

}
