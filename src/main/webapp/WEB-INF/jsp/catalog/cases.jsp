
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
    </tr>
    <c:forEach var="cases" items="${cases}">
    <tr>
        <td> <c:out value="${cases.model}"/></td>
        <td> <c:out value="${cases.maker}"/></td>
        <td> <c:out value="${cases.material}"/></td>
        <td> <c:out value="${cases.typeOfCase}"/></td>
        <td> <c:out value="${cases.powerSupplyUnit}"/></td>
        <td> <c:out value="${cases.price}"/></td>
    </tr>
    </c:forEach>

</table>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
