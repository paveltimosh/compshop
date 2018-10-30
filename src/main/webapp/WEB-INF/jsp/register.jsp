
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form name="registerForm" class="text" id="registerForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="register" />
     Login:<br/>
    <input type="text" name="login" value="" required />
    <div style="color:#ff0000"> ${errorLoginMessage} </div><br/>
     Password:<br/>
    <input type="password" name="password" id="passwordId" value="" required/>
    <div style="color:#ff0000"> ${errorPasswordMessage} </div><br/>
     Confirm password:<br/>
    <input type="password" name="passwordTwo" value="" required/>
    <div style="color:#ff0000"> ${errorPassEqualMessage} </div><br/>
     Email:<br/>
    <input type="email" name="email" value="" required/>
    <div style="color:#ff0000"> ${errorEmailMessage} </div><br/>
    First name:<br/>
    <input type="text" name="firstName" value="" required/>
    <div style="color:#ff0000"> ${errorFirstNameMessage} </div><br/>
    Last name:<br/>
    <input type="text" name="lastName" value="" required/>
    <div style="color:#ff0000"> ${errorLastNameMessage} </div><br/>
    Phone number: <br/>
    <input type="text" name="phoneNumber" value="" required/>
    <div style="color:#ff0000"> ${errorPhoneMessage} </div><br/>
    Address: <br/>
    <input type="text" name="address" value="" required/>
    <div > </div><br/>
    ID of bank card (16 numbers): <br/>
    <input type="text" name="idBankCard" value="" required/>
    <div style="color:#ff0000"> ${errorIdCardMessage} </div><br/><br/>
    <input type="submit" class="button" name="register" value="Register" /><br/>
</form></center>
<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
