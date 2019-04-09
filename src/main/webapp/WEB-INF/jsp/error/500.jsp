
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<h1>Status code: ${pageContext.errorData.statusCode} </h1>
<h3>Request from ${pageContext.errorData.requestURI} is failed</h3>

</body>
</html>
