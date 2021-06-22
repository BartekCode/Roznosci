<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 11.01.2021
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style2.css">
    <title>Chat</title>
</head>
<body>
<%@ include file="WEB-INF/segments/header.jspf"%>
<div class="a">
<h1>Witaj na JavaCzacie!</h1>
    <br>
<p>Poniżej widzisz historię konwersacji, możesz do niej dołączyć</p>
    <br>
</div>
<div class="a">

    <br>
    <ul class="span">
    <p class="czateria">
<%--iterujemy po liście i wyswietlamy userName i text przy uzyciu for each--%>
    <c:forEach items="${applicationScope.users}" var="user">
        <li>
            ${user.userName} : ${user.text}
        </li>
    </c:forEach>
<%--jezeli nie ma żadnej wiadomosci czyli users jest puste--%>
        <c:if test="${empty users}">
            <p>Nie przesłano żadnej wiadomości. Rozpocznij konwersację.</p>
        </c:if>
    </ul>
        <br>
    </p>
    <form action="chat" method="post">
    <textarea name="text"  placeholder="Twoja wiadomosć"></textarea><br>
    <br>
    <input name="username" type="text" placeholder="Twoja nazwa"><br>
    <br>
    <button>Wyślij</button>
</form>
</div>
<jsp:include page="WEB-INF/segments/footer.jsp"></jsp:include>
</body>
</html>
