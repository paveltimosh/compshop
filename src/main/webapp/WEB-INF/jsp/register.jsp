
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="registerForm" class="text" id="registerForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="register" />
    <input type="text" name="login" value="" required /><br/>

    <input type="password" name="password" id="passwordId" value="" required/>Login<br/>
    <input type="password" name="passwordTwo" value="" required/><br/>
    <input type="email" name="email" value="" required/> <br/>
    <input type="submit" class="button" name="Зарегестрироваться" /><br/>
</form>

<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
