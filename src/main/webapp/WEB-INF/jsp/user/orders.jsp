
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<h2>Orders</h2><br>
<div style="color:#ff0000"> ${orderConfirmError} </div><br/>
<div style="color:#2ecd1d"> ${orderConfirmSuc} </div><br/>
<table cellpadding="10">
<tr>
    <th width="100">Name</th>
    <th>Date of order</th>
    <th>Time of order</th>
    <th>Status</th>
    <th>Total amount</th>
    <th>Pay</th>
</tr>
<c:forEach var="order" items="${orders}">
<tr>
    <td>${order.orderDescription}</td>
    <td>${order.dateOfOrder}</td>
    <td>${order.timeOfOrder}</td>
    <td>${order.orderStatus}</td>
    <td>${order.totalAmountOrder}</td>
    <td>
        <c:if test="${order.paymentDescription.typePayment == null}">
            <form name="make_order" class="text" id="makeOrder" method="post" action="/jsp/controller">
                <select id="paymentType" name="paymentType">
                    <option value="CASH">Cash</option>
                    <option value="BANK_CARD">Bank card</option>
                    <option value="CREDIT">Credit</option>
                </select>
                <input type="hidden" name="command" value="confirm_order"/>
                <input type="hidden" name="orderId" value="${order.id}"/>
                <input type="submit" class="button" name="confirm_order_button" value="Confirm order" />
            </form>
        </c:if>
        <c:if test="${order.paymentDescription.typePayment != null }">
            ${order.paymentDescription.typePayment}
        </c:if>
    </td>
</tr>
</c:forEach>

</table><br>
<h3>Own money: ${sessionScope.user.ownMoney}</h3>
<br>
<a href="${pageContext.request.contextPath}/cart"> Back to cart</a>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
