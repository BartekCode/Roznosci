<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 05.01.2021
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poziom nawodnienia</title>
</head>
<body>
<h1>Śledzenie poziomu nawodnienia organizmu</h1>
<form action="control">
    <button name="option" value="water">Dodaj szklankę wody</button><!--option=water-->
    <button name="option" value="clear">Wyzeruj licznik</button> <!--option=clear-->
</form>
<%
    Object water = request.getSession().getAttribute("water");
    if (water==null){
        %>
     <h2>Dziś jeszcze nic nie piłeś!</h2>
<%
    }else {
        %>
     <h2>Dzisiaj wypiłeś: <%=water%>ml wody<h2/>
    <%
    }
%>
</body>
</html>
