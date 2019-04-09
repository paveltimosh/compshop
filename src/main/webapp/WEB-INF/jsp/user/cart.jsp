
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<h1>Cart</h1>
<div style="color:#ff0000"> ${orderError} </div><br/>
<div style="color:#2ecd1d"> ${orderSuccessful} </div><br/>

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
                <form name="compInfoForm" class="text" id="deleteFromCart" method="get" action="/cart/delete">
                    <input type="hidden" name="id" value="${item.key.id}">
                    <input type="submit" class="button" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table><br/>
<h3> Total amount: $ ${summa} </h3><p>
<form name="make_order" class="text" id="makeOrder" method="post" action="/make_order">
    <input type="hidden" name="summa" value="${summa}">
    <input type="submit" class="button" value="Make order" />
</form>
<form name="make_order" class="text" id="makeOrder" method="get" action="/user/orders">
    <input type="submit" class="button"  value="Show orders" />
</form>
<h3>Own money: $ ${sessionScope.user.ownMoney}</h3>

<a href="/main"> Back</a>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
