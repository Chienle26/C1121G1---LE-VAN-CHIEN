<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/29/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Từ điển Anh - Việt</h1>
<form action="/translate">
    <label for="word">Nhập từ cần tra: </label>
    <input type="text" id="word" name="word">
    <button type="submit">Tra cứu</button>
</form>
</body>
</html>
