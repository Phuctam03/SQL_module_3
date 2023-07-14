<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/12/2023
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-User</title>
</head>
<body>
<a href="/UserServlet">Back to list Users</a>
<h3>Are you sure ?</h3>
<form method="post">
    <table>
        <tr>
            <th>id:</th>
            <td>${user.id}</td>
        </tr>
        <tr>
            <th>name:</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>email:</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>country:</th>
            <td>${user.country}</td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete User"></td>
        </tr>
    </table>
</form>
</body>
</html>
