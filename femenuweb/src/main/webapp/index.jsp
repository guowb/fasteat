<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/15
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>商家后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <span class="lp-title-port">餐馆</span><span class="dl-title-text">柜台管理</span>
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${sessionScope.USER.rname}</span><a href="/rest_out.html" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">首页</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/bui.js"></script>
<script type="text/javascript" src="/js/config.js"></script>
<script type="text/javascript" src="/js/common/main-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{
            id: 'menu',
            homePage: 'code',
            menu: [{
                text: '操作导航',
                items: [
                    {id: 'code', text: '首页', href: '/jsp/wel.jsp', closeable: false},
                ]
            }, {
                text: '菜种操作',
                items: [
                    {id: 'operation', text: '添加菜种', href: '/jsp/addType.jsp'},
                    {id: 'quick', text: '查看菜种', href: '/listType.html'}
                ]
            },
                {
                    text: '菜品操作',
                    items: [
                        {id: 'resource', text: '添加菜品', href: '/go_addFood.html'},
                        {id: 'loader', text: '查看菜品', href: '/listFood.html'}
                    ]
                }
                , {
                    text: '订单查看',
                    items: [
                        {id: 'onorder', text: '未完成订单', href: '/listOrder.html?ostatus=0'},
                        {id: 'oldorder', text: '以往订单', href: '/listOrder.html?ostatus=1'},
                    ]
                },
            {
                text: '用户',
                items: [
                    {id: 'resou', text: '用户详情', href: '/UserDetails.html'}
                ]
            }
                ]
        }];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>
