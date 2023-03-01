<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/2/2023
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="emailBox" action="/email" method="post">
        <label>Languages</label>
        <form:select path="languages" items="${languages}"/>
        <label>Page Size: show </label>
        <form:select path="pageSize" items="${pageSize}"/>
        <span> emails per page</span>
        <label class="form-check-label" for="defaultCheck1">
            Spam Filter
        </label>
        <form:checkbox path="spamFilter" class="form-check-input" value="${emailBox.spamFilter}"
                       id="defaultCheck1"/>
        <label>Signature</label>
        <form:textarea path="signature"/>
    <button class="btn btn-danger my-3" type="button"><a class="text-white" style="text-decoration: none"
                                                         href="/showMail">Cancel</a></button>
    <button class="btn btn-primary my-3" type="submit">Update</button>
</form:form>
</body>
</html>
