<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>orders</title>
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--fonts-->
<link href='https://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet'
	  type='text/css'>
	<script type="text/javascript">

	</script>

	<style type="text/css">
		th{
			height: 50px;
			line-height: 50px;
			text-align: center;

		}



	</style>
</head>
<body>
<form>
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

			<h2 class="account-in" style="font-size: 30px">订单</h2>
				<form>
					<div >
					<table style="width: 1000px;color: #747272;font-size: 18px;text-align: center" border="1px">
						<tr>
							<th>订单号</th>
							<th>桌号</th>
							<th>备注</th>
							<th>手机号</th>
							<th>价格</th>
							<th>订单时间</th>
							<th>详情</th>
						</tr>
						<c:forEach items="${list.list}" var="order">
							<tr style="height: 50px">
								<td>${order.id}</td>
								<td>${order.dnum}</td>
								<td>${order.content}</td>
								<td>${order.phone}</td>
								<td>${order.price}</td>
								<td >
									<fmt:formatDate value="${order.createdate}" pattern="yyyy-MM-dd HH:mm:SS"/>
								</td>
								<td>
									<a href="/order/info?id=${order.id}" style="color: #fb5e33">详情</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					</div>

					<div id="div1" style="width: 400px;margin: 0px auto;font-size: 20px">
						<table style="width:300px">
							<tr >
								<td>
								<a href="/order/orderpage?pageIndex=${list.prePage}" >${list.hasPreviousPage?'上一页':""}</a>

								<%--<button href="/order/orderpage?pageIndex=${list.prePage}" ${list.hasPreviousPage?'':"hidden"} >${list.hasPreviousPage?'上一页':""}</button>--%>
								</td>
								<c:forEach begin="${list.navigateFirstPage}" end="${list.navigateLastPage}" var="pageIndex">
									<td>
									<a href="/order/orderpage?pageIndex=${pageIndex}" ${pageIndex==list.pageNum?"style='color: #fb5e33'":""} >${pageIndex}</a>
									</td>
								</c:forEach>
								<td>
								<a href="/order/orderpage?pageIndex=${list.nextPage}" >${list.hasNextPage?'下一页':""}</a>
								</td>

							</tr>
						</table>
					</div>
					<%--<c:if test="${list.pages <= 1}">
					<script type="text/javascript" >
                        $("#div1").hide();
					</script>
					</c:if>--%>
		</div>
	</div>
	</form>
</body>
<script type="text/javascript">
</script>
</html>