<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/20
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>订单展示页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<legend style="color: #0c147a"><b>订单展示</b></legend>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>订单号</th>
        <th>价格</th>
        <th>桌号</th>
        <th>备注</th>
        <th>手机号</th>
        <th>创建时间</th>
        <th>详情</th>
    </tr>
    <c:forEach items="${order}" var="order">
            <td>${order.id}</td>
            <td>${order.price}</td>
            <td>${order.dnum}</td>
            <td>${order.content}</td>
            <td>${order.phone}</td>
            <td>
                <fmt:formatDate value="${order.createdate}" pattern="yyyy-MM-dd HH:mm:SS"/>
            </td>
            <td><a href="/orderDetails.html?oid=${order.id}">订单详情</a></td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>