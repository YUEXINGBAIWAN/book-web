<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>

		<%--		静态包含 manager 管理模块的菜单--%>
		<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>
			<c:forEach items="${requestScope.page.items}" var="orders">

				<tr>
					<td>${orders.createTime}</td>
					<td>${orders.price}</td>
					<td><a href="#">查看详情</a></td>
					<td>
						<c:if test="${orders.status ==0}">
							<a href="orderServlet?action=sendOrder&orderId=${orders.orderId}">点击发货</a>
						</c:if>
						<c:if test="${orders.status ==1}">
							<span>已发货</span>
						</c:if>
						<c:if test="${orders.status == 2}">
							<span>已签收</span>
						</c:if>

					</td>
				</tr>
			</c:forEach>


		</table>
		<%--    静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<%--	静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>