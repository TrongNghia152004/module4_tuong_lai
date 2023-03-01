<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/2/2023
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<div>Languages: ${mailBox.languages}</div>

<div>Page size: Show ${mailBox.pageSize} emails per page</div>

<div>Spam filter: ${spamFilter}</div>

<div>Signature: ${mailBox.signature}</div>

<button class="mt-3 btn btn-primary"><a class="text-white" href="/updateFormMail" style="text-decoration: none">Update</a>
</button>
</body>
</html>
