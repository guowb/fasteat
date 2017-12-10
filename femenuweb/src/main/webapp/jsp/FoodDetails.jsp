<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/20
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                        菜品名称
                    </th>
                    <th>
                        菜品类别
                    </th>
                    <th>
                        菜品价格
                    </th>
                    <th>
                        菜品状态
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        ${food.fname}
                    </td>
                    <td>
                        ${food.type.tname}
                    </td>
                    <td>
                        ${food.fprice}
                    </td>
                    <td>
                        ${food.fnum==1?"上架":"下架"}
                    </td>
                </tr>
                </tbody>
            </table>
            <h2>
                菜品介绍
            </h2>
            <p>
                ${food.fdesc}
            </p>
        </div>
        <div class="span6">
            <img alt="140x140" src="${food.fphoto}" class="img-rounded" />
        </div>
    </div>
</div>
</body>
</html>