<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 03.01.2021
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP with Scriptlets</title>
</head>
<body>
<h1>JSP with Java Code</h1>
<%! int iterations = 0; %>
<%--skryplety--%>
<ul>
    <%
        for (int i = 0; i < iterations; i++) {
            %>
    <li>Element no <%= i%></li>
    <%
        }
    %>
</ul>
</body>
</html>
