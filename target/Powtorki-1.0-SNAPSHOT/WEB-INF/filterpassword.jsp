<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 16.01.2021
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sekretna strona</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/secret" method="post">
    <label for="filterpass">Hasło</label>
    <input type="password" name="filterpass" id="filterpass">
    <button type="submit">Wyślij</button>
</form>
</body>
</html>
