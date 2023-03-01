<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<body>
<h1 class="mb-3">Setting</h1>
<form:form modelAttribute="emailBox" action="/updateEmail" method="post">
    <div class="form-group">
        <label>Languages</label>
        <form:select path="languages" items="${languages}"/>
    </div>
    <div class="form-group mt-2">
        <label>Page Size: show </label>
        <form:select path="pageSize" items="${pageSize}"/>
        <span> emails per page</span>
    </div>
    <div class="form-check mt-2">
        <label class="form-check-label" for="defaultCheck1">
            Spam Filter
        </label>
        <form:checkbox path="spamsFilter" class="form-check-input" value="${emailBox.spamsFilter}"
                       id="defaultCheck1"/>
    </div>
    <div class="form-group mt-3">
        <label>Signature</label>
        <form:textarea path="signature"/>
    </div>
    <button class="btn btn-danger my-3" type="button"><a class="text-white" style="text-decoration: none"
                                                         href="/showEmail">Cancel</a></button>
    <button class="btn btn-primary my-3" type="submit">Update</button>
</form:form>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</body>
</html>
