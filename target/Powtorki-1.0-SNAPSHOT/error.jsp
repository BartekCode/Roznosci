<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 04.01.2021
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Błąd</title>
</head>
<body>
<h2>Wystąpił błąd</h2>
<p>Podano błędne dane</p>
<a href="<%=request.getContextPath()+"/"%>">Powrót do strony głównej</a>
<%--Zwróć uwagę na adres do strony głównej. Dzięki takiemu podejściu nie ma teraz znaczenia pod jakim adresem będzie uruchomiona nasza aplikacja.--%>
</body>
</html>
