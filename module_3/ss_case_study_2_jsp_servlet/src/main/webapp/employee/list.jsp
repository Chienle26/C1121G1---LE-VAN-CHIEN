<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/17/2022
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer</title>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Customer Application</h1>

    <tr>
        <h2>
            <a href="/customers?action=create">Add New Customer</a>
        </h2>
    </tr>
    <tr>
        <form action="/customers" method="post">
            <input type="hidden" name="action" value="search">
            <input type="text" name="searchName">
            <input type="submit" value="Search By ">
        </form>
    </tr>

</center>
<div align="center">
</div>
<table border="1" id="example" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Tên Khách Hàng</th>
        <th>Ngày Sinh</th>
        <th>Giới tính</th>
        <th>CMND</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Địa Chỉ</th>
        <th>Chức Năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.dateOfBirth}"/></td>
            <c:if test="${!customer.gender}">
                <td><c:out value="Nữ"/></td>
            </c:if>
            <c:if test="${customer.gender}">
                <td><c:out value="Nam"/></td>
            </c:if>

            <td><c:out value="${customer.IDNumber}"/></td>
            <td><c:out value="${customer.phoneNumber}"/></td>
            <td><c:out value="${customer.email}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td>
                <a href="/users?action=edit&id=${customer.customerCode}">Edit</a>
                <a href="/users?action=delete&id=${customer.customerCode}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    $.extend( true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    } );
    $(document).ready(function() {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    } );
</script>
</html>
