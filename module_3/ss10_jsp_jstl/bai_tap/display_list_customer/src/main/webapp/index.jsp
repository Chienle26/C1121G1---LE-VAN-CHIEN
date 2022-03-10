<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/10/2022
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>
<h2 style="text-align: center">DANH SÁCH KHÁCH HÀNG</h2>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Tên</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Ảnh</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="i" items="${list1}">
            <tr>
                <td>${i.name}</td>
                <td>${i.dateOfBirth}</td>
                <td>${i.address}</td>
                <td><img width="100" height="100" src="${i.image}" alt=""></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="d-flex justify-content-center">
    <a href="/person">
        <button  name="display" type="button" class="btn btn-primary">Display Customer</button>
    </a>
</div>


</body>
</html>
