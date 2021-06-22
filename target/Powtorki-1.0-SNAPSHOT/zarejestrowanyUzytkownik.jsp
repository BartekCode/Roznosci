<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 03.01.2021
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlets.User" %>
<%@ page import="java.io.Writer" %>
<%@ page import="servlets.UserDataController" %>
<html>
<head>
    <title>Zarejestrowany</title>
</head>
<body>
<h2>Dane odebrane pomyślnie</h2>
<div>
    <%
        UserDataController userDataController = new UserDataController();
        User user = (User) request.getAttribute("user");
        String userName = user.getUserName();
        String gender = user.getGender();
        String password = user.getPassword(); %>
    <p>Nazwa użytkownika: <%=userName%></p>
    <p>Płeć: <%= gender%></p>
    <p>Hasło: <%=password%></p>
   <% if (userDataController.passwordLength(password)==true&&userDataController.bigLetter(password)==true&&userDataController.hasDigit(password)==true) {%>
<p>Hasło spełnia wszystkie kryteria bezpieczeństwa</p>
    <%}else{
       %>
       <p>Hasło nie spełnia wymogów</p>
        <ul>
        <li>Hasło powinno zaiwrać co najmniej jedną wielką literę</li>
        <li>Hasło powinno zaiwrać co najmniej jedną cyfrę</li>
        <li>Hasło powinno mieć minimalną długość 5 znaków</li>
        </ul>
   <% }

        if (user.getHobby()!=null){
            for (String hobby : user.getHobby()) {
                %>
    <p>Hobby:  <%=hobby%></p><br>

        <%
            }
        }
    %>
</div>
</body>
</html>
