<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/13/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student by JSTL</title>
    <style>
        form{
            display: inline;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center><h2>List student by JSTL</h2></center>
<form method="post" action="/product?action=search">
    <label id="search">Search and Create</label>
    <input name="search" type="text">
    <button type=submit>Search</button>
</form>

<button type="button" name="create"><a href="/product?action=create">Create</a></button>
<table border="1">
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <%--for(Student student: studentListServlet)--%>
    <c:forEach var="product" items="${productListServlet}" varStatus="loop">

        <tr>
                <%--            count đếm từ 1--%>
                <%--            index đếm từ 0--%>
            <td>${loop.count}</td>
            <td><c:out value="${product.id}"></c:out></td>
            <td><a href="/product?action=view&id=${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.producer}</td>
            <td><a href="/product?action=update&id=${product.id}">Edit</a></td>
            <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
