
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="registerForm" class="text" id="registerForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="register" />
     Login:<br/>
    <input type="text" name="login" value="" required /><br/>
     Password:<br/>
    <input type="password" name="password" id="passwordId" value="" required/><br/>
     Confirm password:<br/>
    <input type="password" name="passwordTwo" value="" required/><br/>
     Email:<br/>
    <input type="email" name="email" value="" required/> <br/>
    First name:<br/>
    <input type="text" name="firstName" value="" required/> <br/>
    Last name:<br/>
    <input type="text" name="lastName" value="" required/> <br/>
    Phone number: <br/>
    <input type="text" name="phoneNumber" value="" required/> <br/>
    Address: <br/>
    <input type="text" name="address" value="" required/> <br/>
    ID of bank card (16 numbers): <br/>
    <input type="text" name="idBankCard" value="" required/> <br/><br/>
    <input type="submit" class="button" name="Зарегестрироваться" value="Register" /><br/>
</form>

<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
