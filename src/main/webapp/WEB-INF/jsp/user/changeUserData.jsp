
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change user info</title>
</head>
<body>
<h1>Change user info</h1>
<form name="registerForm" class="text" id="registerForm" method="post" action="/jsp/controller">
    <input type="hidden" name="command" value="change_user_info" />
    <input type="hidden" name="userId" value= "${sessionScope.user.id}">
    Email:<br/>
    <input type="email" name="email" value="${sessionScope.user.email}" required/>
    <div style="color:#ff0000"> ${errorEmailMessage} </div><br/>
    First name:<br/>
    <input type="text" name="firstName" value="${sessionScope.user.firstName}" required/>
    <div style="color:#ff0000"> ${errorFirstNameMessage} </div><br/>
    Last name:<br/>
    <input type="text" name="lastName" value="${sessionScope.user.lastName}" required/>
    <div style="color:#ff0000"> ${errorLastNameMessage} </div><br/>
    Phone number: <br/>
    <input type="text" name="phoneNumber" value="${sessionScope.user.phoneNumber}" required/>
    <div style="color:#ff0000"> ${errorPhoneMessage} </div><br/>
    Address: <br/>
    <input type="text" name="address" value="${sessionScope.user.address}" required/>
    <div> </div> <br/>
    ID of bank card (16 numbers): <br/>
    <input type="text" name="idBankCard" value="${sessionScope.user.idCard}" required/>
    <div style="color:#ff0000"> ${errorIdCardMessage} </div><br/><br/>
    <input type="submit" class="button" name="loginButton" value="Submit" /><br/>
</form>

<%@include file="/WEB-INF/jsp/common/footer.jspf"%>
</body>
</html>
