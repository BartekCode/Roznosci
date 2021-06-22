<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 06.01.2021
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notatnik</title>
</head>
<body>
<h1>Notatnik</h1>
<form action="save" method="post"><!--formularz wyslany pod save metoda post-->
    <fieldset>
        <label for="noteId">Identyfikator notatki</label>
        <input name="noteId" id="noteId" />
    </fieldset>
    <fieldset>
        <label for="noteContent">Treść notatki</label>
        <textarea name="noteContent" id="noteContent"></textarea>
    </fieldset>
    <fieldset>
        <label for="privateNote">Notatka prywatna</label>
        <input name="noteType" type="radio" value="priv" id="privateNote"> <!--radio czyli checkbox czy prywatna czy publiczna notatka sciagniemy ja jako tablice-->
        <label for="publicNote">Notatka publiczna</label>
        <input name="noteType" type="radio" value="pub" id="publicNote">
    </fieldset>
    <input type="submit" value="Zapisz"/>
</form>
</body>
</html>
