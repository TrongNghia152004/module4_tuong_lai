<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/2/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Translate</h1>
<form action="/dictionary">
    <input type="text" name="english" value="${english}">
    <button type="submit">Result</button>
</form>
<h1>Result : ${result}</h1>
</body>
</html>
