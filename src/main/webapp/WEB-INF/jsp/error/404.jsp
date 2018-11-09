
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<h1>Status code: ${pageContext.errorData.statusCode} </h1>
<h1>Page ${pageContext.errorData.requestURI} not found!</h1>
<br>
<a href="/main" > Back to main page</a>
</body>
</html>
