
<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change user info</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jspf"%>
<h1>Change user info</h1>

<form:form action="/user/changeProfile" method="post" modelAttribute="userDTO">
    Email:<br/>
    <form:input path="email"  autocomplete="true"/>
    <form:errors path="email"  /><br>
    First name:<br/>
    <form:input path="firstName" autocomplete="some name"  />
    <form:errors path="firstName"  /><br>
    Last name:<br/>
    <form:input path="lastName" autocomplete="${sessionScope.user.lastName}"  />
    <form:errors path="lastName"  /><br>
    Phone number: <br/>
    <form:input path="phoneNumber" autocomplete="${sessionScope.user.phoneNumber}" />
    <form:errors path="phoneNumber"  /><br>
    Address: <br/>
    <form:input path="address" autocomplete="${sessionScope.user.address}" />
    <form:errors path="address"  /><br>
    ID of bank card (16 numbers): <br/>
    <form:input path="idCard" autocomplete="${sessionScope.user.idCard}" />
    <form:errors path="idCard"  /><br>
    <form:button name="changeUser">Submit</form:button>
</form:form>

<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
