<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/2/2023
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<body>
<h1 class="text-center" style="color: red">Sandwich Condiments</h1>
<form class="text-center" style="padding-top: 50px" action="/save-condiments" method="post">
    <input  type="checkbox" value="lettuce" name="condiments"><span class="fs-3 fw-bolder">Lettuce</span>
    <input  type="checkbox" value="tomato" name="condiments"><span class="fs-3 fw-bolder">Tomato</span>
    <input  type="checkbox" value="mustard" name="condiments"><span class="fs-3 fw-bolder">Mustard</span>
    <input  type="checkbox" value="sprouts" name="condiments"><span class="fs-3 fw-bolder">Sprouts</span>
    <br>
    <button type="submit" value="save" class="btn btn-primary">Save</button>
</form>
<h2>The seasoning of your choice: ${condiments}</h2>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</body>
</html>
