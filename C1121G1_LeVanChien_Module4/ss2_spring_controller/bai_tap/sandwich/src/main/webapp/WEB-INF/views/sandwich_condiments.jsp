<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <form action="/sandwich_condiments_choosed">
        <input type="checkbox" id="lettuce" name="lettuce" value="lettuce">
        <label for="lettuce"> Lettuce</label><br>
        <input type="checkbox" id="tomato" name="tomato" value="tomato">
        <label for="tomato"> Tomato</label><br>
        <input type="checkbox" id="mustard" name="mustard" value="mustard">
        <label for="mustard"> Mustard</label><br>
        <input type="checkbox" id="sprouts" name="sprouts" value="sprouts">
        <label for="sprouts"> Sprouts</label><br><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>
