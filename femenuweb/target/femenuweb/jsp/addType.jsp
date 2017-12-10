<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/15
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>菜品种类操作页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
    <link href="/css/prettify.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        code {
            padding: 0px 4px;
            color: #d14;
            background-color: #f7f7f9;
            border: 1px solid #e1e1e8;
        }
    </style>
</head>
<body>
            <div class="span12">
                <form id="T_form" method="post" action="/addType.html">
                    <fieldset>
                        <legend style="color: #0c147a"><b>添加菜种类</b></legend><input type="text" name="tname" id="tname"/><input type="hidden" name="rid" value="${sessionScope.USER.rid}"><span class="help-block">请勿重复菜品种类.</span>
                    </fieldset>
                    <p>
                    <button id="btnSave" class="button button-primary" onclick="sub()">提交</button>
                     </p>
                </form>
            </div>
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
    function sub(){
        var tname = $("#tname").val();
        if (tname==null || tname.trim()==""){
            alert("不能添加空的");
            return;
        }else{
            $("#T_form").submit();
        }
    }
</script>
</body>
</html>