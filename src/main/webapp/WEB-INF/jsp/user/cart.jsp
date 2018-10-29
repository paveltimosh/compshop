
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<h1>Cart</h1>
<table cellpadding="10">
    <colgroup>
        <col span="7" style="background-color: #feb229">
    </colgroup>
    <tr>
        <td>Description</td>
        <td>Price</td>
        <td>Quantity</td>
    </tr>
    <c:forEach var="item" items="${sessionScope.cart}">
        <tr>
            <th>${item.key.compDescription} </th>
            <th>${item.key.price} </th>
            <th>${item.value}</th>
        </tr>
    </c:forEach>
</table>


<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
