<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drivers</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login">
    Username: <input type="text" name="username" placeholder="login" required>
    <br><br>Password: <input type="password" name="password" placeholder="password" required>
    <c:if test="${error}">
    <h5 style="color: red; font-size: 14px">Username or password incorrect!
    </c:if>
    <br><button type="submit">Login</button>
</form>
</body>
</html>
