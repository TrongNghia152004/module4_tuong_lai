<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/2/2023
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Currency conversion</h1>
<form action="/convert" method="get">
    <input type="text" name="USD" value="${USD}">
    <button type="submit" value="Result">Result</button>
</form>
<h1>Result = ${VND}</h1>
</body>
</html>
