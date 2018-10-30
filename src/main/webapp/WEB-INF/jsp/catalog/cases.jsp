
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cases</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
<div>
<table cellpadding="10">
    <colgroup>
        <col span="7" style="background-color: #6ba2fe">
    </colgroup>
    <tr>
        <th>Model </th>
        <th>Maker </th>
        <th>Material </th>
        <th>Type of case </th>
        <th>Power Supply Unit </th>
        <th>Price </th>
        <th>Add to cart</th>
    </tr>
    <c:forEach var="cases" items="${cases}">
    <tr>
        <td> <c:out value="${cases.model}"/></td>
        <td> <c:out value="${cases.maker}"/></td>
        <td> <c:out value="${cases.material}"/></td>
        <td> <c:out value="${cases.typeOfCase}"/></td>
        <td> <c:out value="${cases.powerSupplyUnit}"/></td>
        <td> <c:out value="${cases.price}"/></td>
        <td>
            <form name="addToCart" class="text" id="addToCart" method="post" action="/jsp/controller">
                <input type="hidden" name="command" value="add_to_cart"/>
                <input type="hidden" name="id" value="${cases.id}">
                <input type="hidden" name="description" value="${cases.model}">
                <input type="hidden" name="itemType" value="cases">
                <input type="submit" class="button" name="computer_info" value="Add to cart"/>
            </form>
        </td>
    </tr>
    </c:forEach>

</table>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
