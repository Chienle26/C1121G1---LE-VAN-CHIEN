<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Mail Setting</title>
</head>
<body>
<h1>Mail Setting</h1>

<form:form action="/setting" method="post" modelAttribute="mailSetting">
    <table>
        <tr>
            <th>
                Language:
            </th>
            <td>
                <form:select path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>
                Page Size:
            </th>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th>
                Spams Filter:
            </th>
            <td>
                <form:checkbox path="spamFilter" value="true"></form:checkbox>Enable spams filter
            </td>
        </tr>
        <tr>
            <th>
                Signature:
            </th>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <button>Update</button>
                <button><a href="/setting">Cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
