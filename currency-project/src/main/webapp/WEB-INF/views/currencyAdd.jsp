<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add currency</title>
</head>
<body>
<a href="/currencies"><h2><-</h2></a>
<form method="post" action="${pageContext.request.contextPath}/currency/add">
    <input type="hidden" name="id" value="${id}">
    <br>From currency: <input type="text" value="${from}" name="from" placeholder="from" required>
    <br> <br> From currency: <input type="text" value="${to}" name="to" placeholder="to" required>
    <br>
    <button type="submit">
        <c:if test="${id==null}">Create</c:if>
        <c:if test="${id!=null}">Update</c:if>
    </button>
</form>

</body>
</html>
