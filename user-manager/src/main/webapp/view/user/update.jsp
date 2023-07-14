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
    <title>Update-User</title>
</head>
<body>
<h1>Update-Product</h1>
<a href="/UserServlet">Back to list product</a></br>
<p>${message}</p></br>
<form method="post">
    <table style="text-align: left">
        <tr>
            <th>Name:</th>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <th>Email:</th>
            <td><input type="text" name="email" value="${user.email}"></td>
        </tr>
        <tr>
            <th>country:</th>
            <td><input type="text" name="country" value="${user.country}"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="UpdateUser"></td>
        </tr>
    </table>


</form>


</body>
</html>
