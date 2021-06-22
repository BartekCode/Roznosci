<%@ page import="servlets.Divide" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%--import statyczny , ogoline import by nie powtarzac np czesci strony--%>
<jsp:include page="WEB-INF/segments/header.jspf"></jsp:include>
<%--zasoby, które nie mają być publiczne w katalogu /webapp/WEB-INF. Do elementów,
które się tam znajdują będziemy mieli dostęp z poziomu aplikacji, ale nie da się do nich odwołać z przeglądarki.--%>
<div>
<h1>Dzielniki danej liczby</h1>
<form action="/Powtorki_war_exploded/dzielniki">
</div>
<div>
<input align="center" type="number" name="n"><button>Sprawdź Dzielniki</button>
</div>
</form>
<div>
<h1>Odtwarzacz Youtube</h1>
<p>Adres do filmu</p>
</div>
<form action="video.jsp" >

<div>
 <input type="text"  name="video"><button>Odtwarzacz</button>
    </div>
</form>
<div>
<form action="login.html">
    <h1>Rejestracja użytkownika</h1>
    <input type="submit" value="Rejestruj"><br>
</form>
</div>
<div>
<form action="currency.html">
    <h1>Wymień walute</h1>
    <input type="submit" value="Kantor">
</form>
</div>
<div>
    <form action="lottery.html" method="post">
        <h1>Loteria!!!</h1>
        <input type="submit" value="Wejdź do Loterii">
    </form>
</div>
<div>
    <form action="counter">
        <h1>Licznik odwiedzin strony dzieki Cookie :<%=request.getAttribute("numberOfVisits")%></h1>
       <button>Sprawdz ile razy nas odwiedziłeś</button>
    </form>
</div>
<div>
    <form action="watercontrol.jsp">
        <h1>Sprawdz poziom nawodnienia ogranizmu Sesja</h1>
        <button>Nawodnij sie!</button>
    </form>
</div>
<div>
    <h1>Notatnik</h1>
    <form action="notatki.jsp">
        <button>Wprowadź notatkę</button>
    </form>
</div>
<div>
    <h1>Wspólny edytor tekstu</h1>
    <form action="wspolnyedytor.jsp">
        <button>Przejdź do edytora tekstu</button>
    </form>
</div>
<div>
    <h1>Zaloguj się jako Administrator</h1>
    <form action="logowanie.jsp">
        <button>Zaloguj</button>
    </form>
</div>
<div>
    <h1>Zapisanie osoby expression language</h1>
    <form action="home.jsp">
    <button>Przejdź</button>
    </form>
</div>
<div>
    <form action="chat.jsp">
    <h1>Dołącz do JavaCzatu!</h1>
        <button>Rozpocznij czatowanie</button>
    </form>
</div>
<div>
    <form action="paint.html">
        <h1>Kalkulator zużycia farby</h1>
        <button>Oblicz</button>
    </form>
</div>
<div>
<%--  formularz uruchamia serwlet ktory uzupelnia zawartos sklepu i wchodzi na jego jsp  --%>
    <form action="produkty">
        <h1>Sklep</h1>
        <button>Wejdz do Sklepu</button>
    </form>
</div>
<div>
    <form action="passZFilter">
        <h1>Logowanie z uzyciem filtra</h1>
        <button>Przejdz do logowania</button>
    </form>
</div>
<!-- Deklaracja -->
<%! String name; %>
<!-- Inicjalizacja -->
<% name = "Jan Kowalski"; %>

<!-- Wyrażenie -->
<h1>Witaj <%= name %>!</h1>

<!-- Skryptlet -->
<% for(int i=0; i<5; i++) { %>
<p>Paragraf numer <%= i %></p>
<% } %>
<jsp:include page="WEB-INF/segments/footer.jsp"></jsp:include>
<%--import dynamiczny--%>
</body>
</html>