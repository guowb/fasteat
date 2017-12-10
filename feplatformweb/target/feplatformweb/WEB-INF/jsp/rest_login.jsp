<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/16 0016
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-image: url("/img/timg.jpg");
            background-size: 100% 100%;
            background-attachment: fixed;
            background-repeat:no-repeat;
        }
    </style>
</head>
<script type="text/javascript" src="/js/jquery-easyui-1.5/jquery.min.js"></script>
<body >
<div class="container-fluid" >
    <div class="row-fluid" >
        <div class="span4">
        </div>
        <div class="span4" style="width:50%;text-align:center ;margin: 300px auto;background-color: white ;opacity: 0.9"  >
            <form class="form-inline" action="/rest_login">
                <fieldset>
                    <h3>欢迎回来</h3>
                    <label>请输入手机号</label>
                    <p>${msg}</p>
                    <p>
                        <input id="rphone" type="text"  name="rphone" required/>
                    </p>
                    <p>
                        验证码<button class="btn" type="button" onclick="check()">获取验证码</button>
                    </p>
                    <input type="text"  name="code" />
                    <input type="submit" value="提交">
                </fieldset>
            </form>
        </div>
        <div class="span4">
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function check() {
        $.ajax({
            url:"/check.html",
            data:"rphone="+$("#rphone").val(),
            success:function(data){
                alter(data.msg);
            }
        })
    }
</script>
</html>
