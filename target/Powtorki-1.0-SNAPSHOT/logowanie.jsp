<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 06.01.2021
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Centrum sterowania - Logowanie</title>
</head>
<body>
<h2>Zaloguj się</h2>
<%--dzieki takiemu zapisowi w prosty sposób wyslemy bądz wrocimy gdzie chcemy, z jsp nie odwolujemy sie bezposrednio do innych jsp tworzmy do tego serwlet--%>
<form action="<%=request.getContextPath()+"/login"%>" method="post">
<%--w przypadku atrybutu action także powinniśmy wykorzystywać rozwiązanie z budowaniem adresu w połączeniu z request.getContextPath().--%>
<%--Na szczęście istnieje bardziej uniwersalne rozwiązanie. Jest nim posługiwanie się adresami relatywnymi,
ale nie względem głównego katalogu serwera, ale zamiast tego względem ścieżki aplikacji.
W celu pobrania takiego adresu możemy odwołać się do metody request.getContextPath(). Metoda zwraca ścieżkę aplikacji, przykładowo:--%>
    <div>
        <label for="username">Nazwa użytkownika</label>
        <input name="username" id="username">
    </div>
    <div>
        <label for="password">Hasło</label>
        <input name="password" id="password" type="password">
    </div>
    <input type="submit" value="Zaloguj">
    <!--Formularz ma pole na nazwę użytkownika i hasło. Po wciśnięciu przycisku zostaje wysyłany pod adres /login, metodą POST.-->
</form>
</body>
</html>