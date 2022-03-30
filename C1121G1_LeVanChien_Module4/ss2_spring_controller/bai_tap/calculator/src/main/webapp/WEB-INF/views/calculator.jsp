<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <input type="text" name="number1">
    <input type="text" name="number2"> <br><br>
    <input type="submit" name="addition" value="Addition(+)">
    <input type="submit" name="subtraction" value="Subtraction(-)">
    <input type="submit" name="multiplication" value="Multiplication(X)">
    <input type="submit" name="division" value="Division(/)">
</form>
<h2>Result: ${result}</h2>
</body>
</html>
