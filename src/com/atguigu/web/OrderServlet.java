package com.atguigu.web;

import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.Card;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-08-30 15:24
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //先获取card购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取UseId
        User user = (User) req.getSession().getAttribute("loginuser");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        Integer id = user.getId();
        //生成订单
        String orderId = orderService.createOrder(cart, id);

//        req.setAttribute("orderId", orderId);
        req.getSession().setAttribute("orderId", orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        resp.sendRedirect("/book/pages/cart/checkout.jsp");

    }

    /**
     * 订单分页
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<Order> orders = orderService.showAllOders();
//        req.setAttribute("orders", orders);
//        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);

        //获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Order> page = orderService.page(pageNo, pageSize);

        page.setUrl("orderServlet?action=page");

        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);

    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取订单编号
        String orderId = req.getParameter("orderId");
        //进行发货
        orderService.sendOrder(orderId);
        //重定向到订单管理页面
//        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=page");
        // 重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("loginuser");
        List<Order> orders = orderService.showMyOrders(user.getId());

        //将订单信息存入Request域
        req.setAttribute("orders", orders);
        //转发到页面列表页面: /pages/order/order.jsp
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);

    }

}
