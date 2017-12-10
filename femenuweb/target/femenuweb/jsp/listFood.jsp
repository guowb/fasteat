<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/18
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>菜品详情页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<legend style="color: #0c147a"><b>菜品列表</b></legend>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>菜品名称</th>
        <th>所属类别</th>
        <th>菜品价格</th>
        <th>菜品状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${foodDtoList}" var="food">
        <tr>
            <td >${food.fname}</td>
            <td >${food.type.tname}</td>
            <td >${food.fprice}</td>
            <td >${food.fnum==1?"上架":"下架"}</td>
            <td ><a onclick="que('${food.fid}')">删除</a>&nbsp;&nbsp;<a href="/go_updateFood.html?fid=${food.fid}">修改</a>
                &nbsp;&nbsp;<a href="/updateFnum.html?fid=${food.fid}">上/下架</a>&nbsp;&nbsp;<a href="/Fooddetails.html?fid=${food.fid}">详情</a></td>
        </tr>
    </c:forEach>
    </thead>
</table>
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
    function que(id) {
        if (confirm("确认删除？")){
            window.location.href="/delFood.html?fid="+id;
        }
    }
</script>
</body>
</html>
