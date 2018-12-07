<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form name="loginForm" class="text" id="loginForm" method="post" action="/perform_login">
    Login:<br/>
    <input type="text" name="login"  required autofocus />
    <div style="color:#ff0000"> ${userNotFound} </div>  <br/>
    Password:<br/>
    <input type="password" name="password" id="passwordId" value="" required/>
    <div style="color:#ff0000"> ${wrongPassword} </div> <br/><br/>
    <input type="submit" class="button" name="loginButton" value="Login" /><br/>
<form/>


<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
