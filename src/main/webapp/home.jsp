<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 07.01.2021
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%--W celu korzystania z dodatkowych znaczników na stronie JSP musisz umieścić najpierw dyrektywę taglib postaci:--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--Jeżeli chcesz korzystać z funkcji, na początku dokumentu należy najpierw dodać dyrektywę:--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expression Language</title>
</head>
<body>
<form action="elogin" method="post">
    <fieldset>
        <div>
            <label for="firstName">Imię</label>
            <input name="firstName" id="firstName">
        </div>
        <div>
            <label for="lastName">Nazwisko</label>
            <input name="lastName" id="lastName">
        </div>
        <div>
            <label for="age">Wiek</label>
            <input name="age" id="age">
        </div>
        <div>
            <label>Płeć</label>
            <select name="gender" id="gender">
<%--opcja wyboru z select--%>
                <option value="MALE">Mężczyzna</option>
                <option value="FEMALE">Kobieta</option>
            </select>
        </div>
    </fieldset>
    <input type="submit" value="Zapisz"/>
<%--    <%--%>
<%--        if (request.getAttribute("person")!=null){--%>
<%--    %>--%>
<%--    <h2>Cześć ${person.firstName}</h2>--%>
<%--    <p style="color: ${person.age gt 18 ? 'green' : 'red'}">--%>
<%--        ${person.age gt 18 ? 'Jesteś pełnoletni' : 'Jesteś nieletni'}--%>
<%--    </p>--%>
<%--    <p>Informacje o Twojej przeglądarce: ${header['user-agent']}</p>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
</form>
    <ol>
        <c:forEach items="${applicationScope.people}" var="person">
        <li>
<%--Nas bardziej będzie interesowało zabezpieczenie przed wykonaniem się złośliwego kodu na poziomie strony JSP.
Możesz do tego wykorzystać znacznik JSTL <c:out>. Tekst, który przekażemy mu do wyświetlenia zostanie wyskejpowany,
tzn. nawiasy otwierające i zamykające oraz znaki &, apostrofy i cudzysłowy zostaną zamienione na encje HTML.--%>
             <c:out value="${person.firstName} - ${person.lastName}"/>
            (${person.age} lat)/
                ${person.gender == 'MALE' ? 'Mężczyzna' : 'Kobieta'}
            <c:if test="${person.age >= 18}">
                <span style="color: green">Pełnoletni(a)</span>
            </c:if>
            <c:if test="${person.age <18}">
                <span style="color: red">Nieletni(a)</span>
            </c:if>
        </li>
        </c:forEach>
    </ol>
<%--<ol>--%>
<%--    <%--%>
<%--        List<Person> people = (List<Person>) application.getAttribute("people");--%>
<%--        for (Person person : people) {--%>
<%--    %>--%>
<%--    <li>--%>
<%--        <%=person.getFirstName() + " - " + person.getLastName() + "("--%>
<%--                + person.getAge() + " lat) / " + (person.getGender() == Gender.MALE ? "Mężczyzna" : "Kobieta")--%>
<%--        %>--%>
<%--        <%--%>
<%--            if(person.getAge() >= 18) {--%>
<%--        %>--%>
<%--            <span style="color: green">Pełnoletni(a)</span>--%>
<%--        <%--%>
<%--        } else {--%>
<%--        %>--%>
<%--            <span style="color: red">Nieletni(a)</span>--%>
<%--        <%--%>
<%--        }--%>
<%--        %>--%>
<%--    </li>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--</ol>--%>
<h2>To co o Tobie wiemy:</h2>
<h3>Ciasteczka (${fn:length(cookie)}):</h3>
<c:forEach var="cookieItem" items="${cookie}">
    <p>${cookieItem.key} : ${cookieItem.value}</p>
</c:forEach>

<h3>Informacje z nagłówków (${fn:length(header)}):</h3>
<c:forEach var="headerItem" items="${header}">
    <p>${headerItem.key} : ${headerItem.value}</p>
</c:forEach>
<c:if test="${not empty param.password}">
    <c:choose>
        <c:when test="${param.password eq 'java'}">
        <p>Java jest suoer najlepsza i w ogóle</p>
        </c:when>
        <c:when test="${param.password eq 'python'}">
            <p>Python jest fajny, ale Java lepsza</p>
        </c:when>
        <c:otherwise>
            <p>Dla takiego hasła nie ma żadnej ukrytej widomości</p>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>
