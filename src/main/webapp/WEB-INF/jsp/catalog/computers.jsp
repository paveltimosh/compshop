<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Computers</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<%@include file="/WEB-INF/jsp/common/menu.jsp"%>
<h2>Computers</h2>
<div class="table-row-cell">

        <table cellpadding="10">
            <colgroup>
                <col span="9" style="background-color: #fef65d">
            </colgroup>
            <tr>
                <th>Computer Model</th>
                <th>Case</th>
                <th>Motherboard </th>
                <th>RAM </th>
                <th>CPU </th>
                <th>Video card</th>
                <th>Price</th>
                <th>Add to cart</th>

            </tr>
            <c:forEach var="computer" items="${computerList}">
            <tr>
                <td>
                    <a href="/catalog/computer/info/${computer.id}" > <c:out value="${computer.model}"/></a>
                </td>
                <td> <c:out value="${computer.cases.model}"/></td>
                <td> <c:out value="${computer.cpu.model}"/></td>
                <td> <c:out value="${computer.motherBoard.model}"/></td>
                <td> <c:out value="${computer.ram.model}"/></td>
                <td> <c:out value="${computer.videoCard.model}"/></td>
                <td> <c:out value="${computer.price}"/></td>
                <td>
                    <form name="addToCart" class="text" id="addToCart" method="post" action="/catalog/addToCart">
                        <input type="hidden" name="command" value="add_to_cart"/>
                        <input type="hidden" name="id" value="${computer.id}">
                        <input type="hidden" name="description" value="${computer.model}">
                        <input type="hidden" name="itemType" value="computers">
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
