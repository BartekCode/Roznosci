<%@ page import="currencyExchange.ExchangeResult" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="currencyExchange.ExchangeType" %><%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 04.01.2021
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kantor-wynik</title>
</head>
<body>
<jsp:include page="WEB-INF/segments/header.jspf"></jsp:include>
<%
    //JSP. W celu pobrania atrybutu wywołujemy metodę getAttribute() i przekazujemy jej jako argument nazwę atrybutu.
    // Metoda getAttribute() zawsze zwraca w wyniku referencję typu Object, dlatego konieczne jest jej rzutowanie na odpowiedni typ - ExchangeResult
    ExchangeResult exchangeResult = (ExchangeResult) request.getAttribute("result");
    BigDecimal base = exchangeResult.getBase();
    BigDecimal result = exchangeResult.getResult();
    ExchangeType exchangeType = exchangeResult.getExchangeType();
    String baseCurrency = exchangeType.getBaseCurrency();
    String targetCurrency = exchangeType.getTargetCurrency();
%>
<h2>
    <%= String.format("%s%s to %s%s",base.toString(),baseCurrency,result.toString(),targetCurrency)%>
</h2>
<jsp:include page="WEB-INF/segments/footer.jsp"></jsp:include>
</body>
</html>
