<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/20
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>用户详情页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<legend style="color: #0c147a"><b>用户详情</b></legend>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                        用户编号
                    </th>
                    <th>
                        用户名称
                    </th>
                    <th>
                        联系电话
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        ${User.rid}
                    </td>
                    <td>
                        ${User.rname}
                    </td>
                    <td>
                        ${User.rphone}
                    </td>
                </tr>
                </tbody>
            </table>
            <h2>
                简介
            </h2>
            <p>
                ${User.rdesc}
            </p>
        </div>
        <div class="span6">
            <img alt="140x140" src="${User.rcode}" class="img-rounded" width="200px" />
        </div>
    </div>
</div>
</body>
</html>