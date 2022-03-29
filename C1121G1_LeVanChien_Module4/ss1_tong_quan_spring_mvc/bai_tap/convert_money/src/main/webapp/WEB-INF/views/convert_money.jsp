<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<h1>Chuyển đổi tiền tệ</h1>
    <form action="/result" method="post">
        <label>Nhập số tiền USD:</label>
        <input type="text" name="money" id="money">
        <br>
        <label>Nhập giá USD hiện tại:</label>
        <input type="text" name="price" id="price">
        <br>
        <button type="submit">Chuyển đổi</button>
    </form>

</body>
</html>
