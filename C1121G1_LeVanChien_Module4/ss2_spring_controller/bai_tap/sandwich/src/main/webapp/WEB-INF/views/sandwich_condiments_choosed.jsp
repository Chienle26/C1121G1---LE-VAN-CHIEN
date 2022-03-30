<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Sandwich Condiments Choosed</title>
    <style>
        h2{
            margin-left: 50px;
        }
    </style>
</head>
<body>
<h1>List Sandwich Condiments Choosed: </h1>
<h2>${lettuce}</h2>
<h2>${tomato}</h2>
<h2>${mustard}</h2>
<h2>${sprouts}</h2>
<br>
<a href="/sandwich_condiments">Back to choose</a>
</body>
</html>
