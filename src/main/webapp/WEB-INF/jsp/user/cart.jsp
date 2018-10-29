
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
        <col span="8" style="background-color: #feb229">
    </colgroup>
    <tr>
        <td>Description</td>
        <td>Price</td>
        <td>Quantity</td>
    </tr>
    <c:forEach var="item" items="${sessionScope.cart}">
        <c:set var="summa" value="${item.key.price + summa}"/>
        <tr>
            <th>${item.key.model} </th>
            <th>${item.key.price} </th>
            <th>${item.value}</th>
        </tr>
    </c:forEach>

</table><br/>
<h3> Total amount: ${summa}</h3>
<a href="${pageContext.request.contextPath}/main"> Back</a>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
