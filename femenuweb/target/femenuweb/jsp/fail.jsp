<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/15
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title> 失败页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/css/page-min.css" rel="stylesheet" type="text/css" />

</head>
<body>

<div class="container">
    <div class="row">
        <div class="span10">
            <div class="tips tips-large tips-warning">
                <span class="x-icon x-icon-error">×</span>
                <div class="tips-content">
                    <h2>操作失败</h2>
                    <p class="auxiliary-text">
                        你可以继续操作以下内容：
                    </p>
                    <p>
                        <a class="page-action" data-type="setTitle" title="继续编辑" href="#" onclick="history.back()">继续编辑</a>
                        <a class="page-action" data-type="close" title="关闭本页" href="#">关闭本页</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/bui-min.js"></script>
<script type="text/javascript" src="/js/common/page-min.js"></script>
<script type="text/javascript" src="/js/config-min.js"></script>
<script type="text/javascript">
    BUI.use('common/page');
</script>

</body>
</html>
