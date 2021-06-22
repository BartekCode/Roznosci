<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 14.01.2021
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sklep</title>
</head>
<%@ include file="WEB-INF/segments/header.jspf"%>
<body>
<h1>Witaj na stronie naszego sklepu</h1>
<p>Kupisz u nas m.in.:</p>
<ul>
<%--  iterujemy przy uzyciu for each  --%>
    <c:forEach var="product" items="${requestScope.products}">
        <li><c:out value="${product}"/> </li>
    </c:forEach>
</ul>
</body>
<jsp:include page="WEB-INF/segments/footer.jsp"></jsp:include>
</html>
