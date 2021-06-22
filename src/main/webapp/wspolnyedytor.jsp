<%--
  Created by IntelliJ IDEA.
  User: Bartekk
  Date: 06.01.2021
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

    <script>
        tinymce.init({
            selector: '#mytextarea'
        });
    </script>

</head>

<body>
<h1>Wspólny edytor</h1>
<form action="edytor" method="post">
    <textarea id="mytextarea" name="text">
        <%
            if(request.getAttribute("text")==null){
                %>

            <%}else {%>
               <%=request.getAttribute("text")%>
          <%}%>
    </textarea>
    <button style="width: 100%; margin-top: 20px">Zapisz zmiany</button>
</form>
</body>