
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CPU</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
<h2>CPU's</h2>
<div>
    <table cellpadding="10">
        <colgroup>
            <col span="7" style="background-color: #6ba2fe">
        </colgroup>
        <tr>
            <th>Model </th>
            <th>Maker </th>
            <th>Type of processor </th>
            <th>Number of cores </th>
            <th>Speed </th>
            <th>Price </th>
            <th>Add to cart</th>
        </tr>
        <c:forEach var="item" items="${cpuList}">
            <tr>
                <td> <c:out value="${item.model}"/></td>
                <td> <c:out value="${item.maker}"/></td>
                <td> <c:out value="${item.processorType}"/></td>
                <td> <c:out value="${item.numberOfCores}"/></td>
                <td> <c:out value="${item.cpuSpeed}"/></td>
                <td> <c:out value="${item.price}"/></td>
                <td>
                    <form name="addToCart" class="text" id="addToCart" method="post" action="/catalog/addToCart">
                        <input type="hidden" name="command" value="add_to_cart"/>
                        <input type="hidden" name="id" value="${item.id}">
                        <input type="hidden" name="description" value="${item.model}">
                        <input type="hidden" name="itemType" value="cpu">
                        <input type="submit" class="button" name="add_to_cart" value="Add to cart"/>
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>

</body>
</html>
