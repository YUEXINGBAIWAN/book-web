package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-08-30 14:38
 */
public class OrderDaoTest {

    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("123456789",new Date(),new BigDecimal(100),0,1));

    }
//    @Test
//    public void queryOrders(){
//        for (Order queryOrders : orderDao.queryOrders()) {
//            System.out.println(queryOrders);
//        };
//    }
}