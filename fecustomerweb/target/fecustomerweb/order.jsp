<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
</head>
<body>


    <table>
        <tr>
            <th>序号</th>
            <th>菜名</th>
            <th>数量</th>
            <th>价格</th>
        </tr>
        <c:forEach items="${order.items}" var="item" varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${item.food.fname}</td>
            <td>${item.fnum}</td>
            <td>${item.price}</td>
        </tr>
        </c:forEach>

    </table>

总价:${order.price}
</body>
</html>
