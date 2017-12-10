<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Account</title>
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--fonts-->
<link href='https://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet'
	  type='text/css'>
</head>
<body>
  <!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
			<div class="header-top-in">
			</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="account">
			<h2 class="account-in"  style="font-size: 30px">详情页</h2>
					<div >
						<table style="width: 1000px;color: #747272;font-size: 18px;text-align: center" border="1px" >
							<tr style="height: 50px">
								<th>订单号</th>
								<th>食物编号</th>
								<th>食物名字</th>
								<th>数量</th>
								<th>价格</th>
								<th>桌号</th>
								<th>备注</th>
								<th>手机号</th>
								<th>创建时间</th>
							</tr>
								<c:forEach items="${order.items}" var="item">
									<tr style="height: 50px">
										<td>${item.oid}</td>
										<td>${item.fid}</td>
										<td>
											<c:forEach items="${foods}" var="food">
												${item.fid==food.fid?food.fname:''}
											</c:forEach>
										</td>
										<td>${item.fnum}</td>
										<td>${item.price}</td>
										<td>${order.dnum}</td>
										<td>${order.content}</td>
										<td>${order.phone}</td>
										<td>
											<fmt:formatDate value="${order.createdate}" pattern="yyyy-MM-dd HH:mm:SS"/>
										</td>
									</tr>
								</c:forEach>
						</table>
					</div>
			<div style="position: absolute;left: 100px; bottom: 30px">
				<div id="div1"style="float: left" >
					<form method="post" action="/order/orderpage">
							<input type="submit"  value="返回">
					</form>
				</div>
				<div id="div2" style="float: left ">
					<form method="post" action="/order/update?id=${param.id}">
							<input type="submit" value="完成">
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>