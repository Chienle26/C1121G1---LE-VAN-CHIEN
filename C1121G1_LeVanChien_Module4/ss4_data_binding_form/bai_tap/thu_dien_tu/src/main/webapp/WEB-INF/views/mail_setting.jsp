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
                <form:select path="language" items="${listLanguage}" />
            </td>
        </tr>
        <tr>
            <th>
                Page Size:
            </th>
            <td>
                Show
                <form:select path="pageSize" items="${listPageSize}" />
                emails per page
            </td>
        </tr>
        <tr>
            <th>
                Spams Filter:
            </th>
            <td>
                <form:checkbox path="spamFilter" value="true" /> Enable spams filter
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
