<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/17
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title> 种类详情页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<legend style="color: #0c147a"><b>菜品种类</b></legend>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th >种类名称</th>
        <th >操作</th>
    </tr>
    <c:forEach items="${typeList}" var="type">
        <tr>
            <td >${type.tname}</td>
            <td ><a onclick="que('${type.tid}')">删除</a>&nbsp;&nbsp;<a href="/go_updateType.html?tid=${type.tid}">修改</a></td>
        </tr>
    </c:forEach>
    </thead>
</table>
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
    function que(id) {
        if (confirm("确认删除？")){
            window.location.href="/delType.html?tid="+id;
        }
    }
</script>
</body>
</html>
