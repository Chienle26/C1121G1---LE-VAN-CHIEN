<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/13/2022
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Product</h1>
<form method="post">
    <p>Name: </p>
    <input type="text" name="name" value="${product.name}">
    <p>Price: </p>
    <input type="text" name="price" value="${product.price}">
    <p>Description: </p>
    <input type="text" name="description" value="${product.description}">
    <p>Manufacture: </p>
    <input type="text" name="producer" value="${product.producer}">
    <button type="submit">Update</button>
</form>
</body>
</html>