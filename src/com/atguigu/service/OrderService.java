package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-08-30 14:49
 */
public interface OrderService {

    public String createOrder(Cart cart,Integer userId);

    Page<Order> page(int pageNo, int pageSize);;

    void sendOrder(String orderId);

    List<Order> showMyOrders(int userId);
}
