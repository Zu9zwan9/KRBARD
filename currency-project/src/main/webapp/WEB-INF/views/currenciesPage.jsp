<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currencies</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>
<style>
    .table-striped {
        margin-left: 30%; /* Фиксированная ширина ячеек */
        margin-right: 30%;
        width: 40%; /* Ширина таблицы */
    }

    .login {
        margin-left: 90%;
    }

    .create {
        border-color: orange;
        border-style: solid;
        font-size: 16px;
        color: black;
        margin-left: 30%;
        text-decoration: none;
    }

    a {
        text-decoration: none;
        color: black;
    }
</style>
<body>
<c:if test="${!admin}"><h3 style="margin-left: 33%; margin-top: 5%">Exchange rates on ${currentDate}</h3></c:if>
<c:if test="${!admin}"><a class="login" href="/login">login</a></c:if>
<c:if test="${admin}"><a class="login" href="/logout">logout</a>
    <br><a class="create" href="/currency/add">Add currency</a>
</c:if>
<br>
<br>
<table class="table table-striped">
    <tr>
        <th>FROM</th>
        <th>TO</th>
        <c:if test="${!admin}">
            <th>Value</th>
        </c:if>
    </tr>
    <c:if test="${!admin}">
        <c:forEach var="c" items="${currencies}">
            <c:forEach items="${c.dateValue}" var="entry">
                <c:if test="${currentDate eq entry.key}">
                    <tr>
                        <td>
                            <c:out value="${c.from}"/>
                        </td>
                        <td>
                            <c:out value="${c.to}"/>
                        </td>
                        <td>
                            <c:out value="${entry.value}"/> <c:out value="${c.to}"/>
                        </td>
                        <td>
                            <a href="/currency?id=${c.id}&from=${currentDate}&to=${currentDate}">Details</a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </c:forEach>
    </c:if>

    <c:if test="${admin}">
        <c:forEach var="c" items="${currencies}">
            <tr>
                <td>
                    <c:out value="${c.from}"/>
                </td>
                <td>
                    <c:out value="${c.to}"/>
                </td>
                <td>
                    <a href="/currency?id=${c.id}&from=${currentDate}&to=${currentDate}">Details</a>
                </td>
                <td>
                    <a href="/currency/add?id=${c.id}">Edit</a>
                </td>
                <td>
                    <a href="/currency/delete?id=${c.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
