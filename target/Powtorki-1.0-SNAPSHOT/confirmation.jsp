<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 06.01.2021
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notatka zapisana</title>
</head>
<body>
<h2>Notatka została zapisana</h2>
<a href="<%=request.getAttribute("noteUrl")%>">Przejdź do notatki</a>
</body>
</html>
