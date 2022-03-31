<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Mail Setting</title>
</head>
<body>
<h1>Mail Setting</h1>
<p style="color: green;">${message}</p>
    <table>
        <tr>
            <th>
                Language:
            </th>
            <td>
                ${mailSetting.language}
            </td>
        </tr>
        <tr>
            <th>
                Page Size:
            </th>
            <td>
                Show
                ${mailSetting.pageSize}
                emails per page
            </td>
        </tr>
        <tr>
            <th>
                Spams Filter:
            </th>
            <td>
                <c:if test="${mailSetting.spamFilter==true}">Yes</c:if>
                <c:if test="${mailSetting.spamFilter==false}">No</c:if>
            </td>
        </tr>
        <tr>
            <th>
                Signature:
            </th>
            <td>
                ${mailSetting.signature}
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <button><a href="/setting">Setting</a></button>
            </td>
        </tr>
    </table>
</body>
</html>
