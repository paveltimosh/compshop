
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="short" href="/img/logo.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/css/foundation.css"/>
</head>
<body>

    <div>
        <c:choose>
            <c:when test="${sessionScope.user == null}">
                You can register <a href="/WEB-INF/jsp/register.jsp" class="button tiny" > Register </a> <br>
                Or you can login <a href="<%= request.getContextPath() %>/WEB-INF/jsp/login.jsp" class="button tiny"> Login </a>
            </c:when>
            <c:otherwise>


            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
