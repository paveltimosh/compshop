
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
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Delete from cart</th>
    </tr>
    <c:forEach var="item" items="${sessionScope.cart}">
        <c:set var="summa" value="${item.key.price + summa}"/>
        <tr>
            <td>${item.key.model} </td>
            <td>${item.key.price} </td>
            <td>${item.value}</td>
            <td>
                <form name="compInfoForm" class="text" id="deleteFromCart" method="post" action="/jsp/controller">
                    <input type="hidden" name="command" value="delete_from_cart"/>
                    <input type="hidden" name="id" value="${item.key.id}">
                    <input type="submit" class="button" name="delete_item" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>
<h3> Total amount: ${summa}</h3>
<a href="${pageContext.request.contextPath}/main"> Back</a>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
