<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 04.01.2021
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="loteria.WynikiLoterii" %>
<html>
<head>
    <title>Wynik losowania</title>
    <link rel="stylesheet"href="loteira.css">
</head>
<body>
<div>
<!--Metoda getAttribute() zwraca referencję typu Object, dlatego konieczne jest rzutowanie. Dalej, przy pomocy skryptletów wyświetlamy listy oraz liczbę trafień-->
<% WynikiLoterii result = (WynikiLoterii) request.getAttribute("lotteryResult"); %>
<%--  pobieramy nasz obiekt wynikiLoterii zapisany jako "lotteryResult" i dzieki geterą pobieramy listy --%>
<h1> Wynik losowania: <%= result.getLotteryNumbers()%> </h1>
<h1>Twoje liczby: <%= result.getUserNumbers()%></h1>
<h1>Liczba trafień: <%= result.getWinNumbers().size() %></h1>
<h1>Trafione liczby: <%=  result.getWinNumbers()%></h1>
</div>
</body>
</html>
