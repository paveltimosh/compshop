
<%@ page language="java"
         contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form:form id="user/register" action="/user/register" method="post" modelAttribute="newUser">
    <form:errors  path = ""  element = "div" />
     Login:<br/>
    <form:input path="login" value="" />
    <form:errors path="login"  /><br>
     Password:<br/>
    <form:input path="password" />
    <form:errors path="password"  /><br>
     Confirm password:<br/>
    <form:input path="passwordTwo" />
    <form:errors path="passwordTwo"  /><br>
     Email:<br/>
    <form:input path="email"  />
    <form:errors path="email"  /><br>
    First name:<br/>
    <form:input path="firstName" />
    <form:errors path="firstName"  /><br>
    Last name:<br/>
    <form:input path="lastName" />
    <form:errors path="lastName"  /><br>
    Phone number: <br/>
    <form:input path="phoneNumber"  />
    <form:errors path="phoneNumber"  /><br>
    Address: <br/>
    <form:input path="address"/>
    <form:errors path="address"  /><br>
    <div > </div><br/>
    ID of bank card (16 numbers): <br/>
    <form:input path="idCard"/>
    <form:errors path="idCard"  /><br><br>
    <form:button name="Register">Register</form:button>
</form:form>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
