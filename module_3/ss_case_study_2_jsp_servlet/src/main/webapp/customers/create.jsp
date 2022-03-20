<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/18/2022
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers">List All Customers</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Code:</th>
                <td>
                    <input type="text" name="customerCode" id="customerCode" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Type Code:</th>
                <td>
                    <input type="text" name="customerTypeCode" id="customerTypeCode" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Date Of Birth:</th>
                <td>
                    <input type="text" name="dateOfBirth" id="dateOfBirth" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" id="gender" size="15"/>
                </td>
            </tr>
            <tr>
                <th>ID number:</th>
                <td>
                    <input type="text" name="IDNumber" id="IDNumber" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Phone number:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Adress:</th>
                <td>
                    <input type="text" name="address" id="address" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>