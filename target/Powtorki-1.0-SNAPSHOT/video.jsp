<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 03.01.2021
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Youtube Player</title>
    <link rel="stylesheet" href="style.css">
</head>
<body >
<h1 align="center">Odtwarzacz Youtube</h1>
<%--pobieramy parametr video ktory utworzylismy w index.jsp--%>
<% String videos = request.getParameter("video");
    if (videos==null) { %>
<p align="center">Brak parametru video w adresie URL</p>
<% }else{
  //  for (String videoid : videos) {
        %>
<div>
<iframe id="ytplayer" type="text/html" width="640" height="360"
        src="http://www.youtube.com/embed/<%=videos%>" frameborder="0"></iframe>
</div>
<div>
    <iframe id="ytplayer1" type="text/html" width="640" height="360"
            src="http://www.youtube.com/embed/<%=videos%>" frameborder="0"></iframe>
</div>
<%
  //  }
}

%>

</body>
</html>
