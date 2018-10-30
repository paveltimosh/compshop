<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>

<h1>It's your profile, ${sessionScope.user.login} ! </h1>
<b>Login: </b> ${sessionScope.user.login}<br/>
<b>Email: </b> ${sessionScope.user.email}<br/>
<b>First Name: </b> ${sessionScope.user.firstName}<br/>
<b>Last Name: </b> ${sessionScope.user.lastName}<br/>
<b>Phone Number: </b> +375 ${sessionScope.user.phoneNumber}<br/>
<b>Address: </b> ${sessionScope.user.address}<br/>
<b>ID of bank card: </b> ${sessionScope.user.idCard}<br/><br/>

<form name="changeUserInfo" method="POST" action="${pageContext.request.contextPath}/editinfo" autocomplete="off">
    <input type="submit" class="button" value="Change profile info"/>
</form><br/>
<a href="${pageContext.request.contextPath}/main"> Back</a>

<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
