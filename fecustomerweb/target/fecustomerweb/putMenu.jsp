<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>饭店详情</title>
</head>
<body>

<h5>${restaurant.rname}<a href="/order?phone=${phone}">查看订单</a></h5>
<div style="width: 100%;height:80%">
    <div style="width: 20%;height: 100%;float: left">
        <c:forEach items="${types}" var="type">
            <ul>
        <li><input type="button" onclick="getFoods(${type.tid})" name="tid" value="${type.tname}" style="width: 50px;height: auto"></li>

            </ul>

        </c:forEach>
    </div>
    <div style="width:80%; height: 100%;float: left" id="div_food">

    </div>
</div>
<script src="/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
    function getFoods(obj){
        $.ajax({
            url:"food",
            data:"tid="+obj,
            method:"POST",
            success:function (data) {
                var $div_food = $("#div_food");
                 $div_food[0].innerHTML="";
                $(data.foods).each(function(){

                    var $fname = $("<p>"+this.fname+"<p>");
                    var $fprice = $("<p>"+this.fprice+"<p>");
                    var $fphoto = $("<img src='"+this.fphoto+"'><br>");
                    var $fnum=$("<input type='button' value='-' onclick='jianNum()'><label id='inputfnum'  style='color: red;' >"+this.fnum+"</label><input type='button' value='+' onclick='jiaNum()'>")
                    var $addItem = $("<input type='button' value='加入订单' onclick='addItem("+this.fid+")'>");
                    $div_food.append($fname).append($fprice).append($fnum).append($fphoto).append($addItem);

                });
            }

            
        });
        
    }
    function jianNum() {
        var fnum=document.getElementById("inputfnum").innerHTML;
        if(fnum<=1){
            return false;
        }
        if(fnum>1){
            $("#inputfnum").html("");
            var num=fnum-1;
            $("#inputfnum").html(num);
        }
    }
    function jiaNum() {
        var fnum=document.getElementById("inputfnum").innerHTML;
        $("#inputfnum").html("");
        var num=fnum-(-1);
        $("#inputfnum").html(num);
    }
    function addItem(obj){
        var num=$("#inputfnum").html();
        $.ajax({
            url:"item",
            data:"fid="+obj+"&phone=${phone}&fnum="+num,
        //{"fid":obj,"phone":${phone},"fnum":num}
            method:"post",
            success:function (data) {
                alert("添加成功");
            }



        })

    }
</script>
</body>
</html>