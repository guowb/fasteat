<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/20
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>订单详情页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<legend style="color: #0c147a"><b>订单详情</b></legend>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>订单号</th>
        <th>${order.id}</th>
    </tr>
    <tr>
        <th>价格</th>
        <th>${order.price}</th>
    </tr>
    <tr>
        <th>桌号</th>
        <th>${order.dnum}</th>
    </tr>
    <tr>
        <th>备注</th>
        <th>${order.content}</th>
    </tr>
    <tr>
        <th>手机号</th>
        <th>${order.phone}</th>
    </tr>
    <tr>
        <th>创建时间</th>
        <th> <fmt:formatDate value="${order.createdate}" pattern="yyyy-MM-dd HH:mm:SS"/></th>
    </tr>
    <c:forEach items="${order.itemDtoList}" var="item">
        <tr><th>菜品/数量</th>
            <th>${item.fname}/${item.fnum}</th>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>