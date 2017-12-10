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
<script type="text/javascript" src="/js/jquery-1.10.1.min.js"></script>
<body >
<div class="container-fluid" >
    <div class="row-fluid" >
        <div class="span4">
        </div>
        <div class="span4" style="width:50%;text-align:center ;margin: 300px auto;background-color: white ;opacity: 0.9"  >
            <form class="form-inline" id="form" action="/rest_reg1">
                <fieldset>
                    <h3>欢迎注册</h3>
                    <label>商店名称</label>
                    <p>
                        <input id="rname" type="text"  name="rname" required/>
                    </p>

                    <label>商店联系方式</label>
                    <p>
                        <input id="rphone" type="text"  name="rphone" onblur="check('q')" required/>
                    <span id="msg"></span>
                    </p>
                    <label>商店介绍</label>
                    <p>
                        <input id="rdesc" type="text"  name="rdesc" required height="50px"/>
                    </p>
                    <label>短信发送量</label>
                    <p>
                        <input id="rmaxday" type="text"  name="rdaymax" required/>
                    </p>
                    <input type="button" value="提交" onclick="check('btn')">
                </fieldset>
            </form>
        </div>
        <div class="span4">
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function check(obj) {
        if($("#msg").val()==null)
        {
            return;
        }
        $.ajax({
            url:"/check2.html",
            dataType:"JSON",
            data:"rphone="+$("#rphone").val(),
            success:function (result) {
                alert(result.msg);
                $("#msg").html(result.msg);
                if(result.status==true&&obj=='btn'){
                    $("form").submit();
                }
            }
        })
    }
</script>
</html>
