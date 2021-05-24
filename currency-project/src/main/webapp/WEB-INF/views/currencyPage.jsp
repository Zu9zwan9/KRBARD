<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drivers</title>
</head>
<style>
    .create {
        border-color: orange;
        border-style: solid;
        font-size: 16px;
        color: black;
        margin-left: 30%;
        text-decoration: none;
    }
</style>
<body>
<a href="/currencies"><h2><-</h2></a>
<form method="post" action="${pageContext.request.contextPath}/currency">
    <input type="hidden" name="id" value="${currency.id}">
    From: <input type="date" id="from" name="from"
                 value="${from}">
    To: <input type="date" id="to" name="to"
               value="${to}">
    <button type="submit">Search</button>
</form>
<br>
<c:if test="${admin}">
    Add currency rate
    <br><br>
    <form method="post" action="${pageContext.request.contextPath}/rate/add">
        <input type="hidden" name="id" value="${currency.id}">
        Date: <input type="date" name="date" required>
        Value: <input type="number" name="value">
        <button type="submit">Add rate</button>
    </form>
</c:if>
<br><br>
<table border="2">
    <h2>${currency.from}-${currency.to}</h2>
    <tr>
        <th>DATE</th>
        <th>VALUE</th>
    </tr>
    <c:forEach items="${map}" var="entry">
    <tr>
        <td>
            <c:out value="${entry.key}"/>
        </td>
        <td>
            <c:out value="${entry.value}"/>
        </td>
        <c:if test="${admin}">
        <td>
            <a href="${pageContext.request.contextPath}/rate/delete?id=${currency.id}&date=${entry.key}">
                Delete
            </a>
        </td>
        </c:if>
        </c:forEach>
</table>
</body>
</html>
