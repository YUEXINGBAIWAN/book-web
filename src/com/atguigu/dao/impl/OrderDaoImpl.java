package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-08-30 14:20
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(orderid,createtime,price,status,userid) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_order";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Order> queryOrders(int begin, int pageSize) {
//        String sql = "select * from t_order;";
//        return queryForList(Order.class, sql);
        String sql = "select * from t_order order by createtime desc " +
                "limit ?,?";
        return queryForList(Order.class, sql, begin, pageSize);
    }

    @Override
    public int sendOrder(String orderId, int status) {
        String sql = "update t_order set `status`=? where orderid=?";
        return update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        String sql = "select * from t_order where userid= ?";
        return queryForList(Order.class, sql, userId);
    }

}
